import java.time.LocalDate;
import java.time.*;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String args[]) {
        int day, month, year;
        Scanner input = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();

        System.out.print("Enter your Birth Day (1-31): ");
        day = input.nextInt();

        System.out.print("Enter your Birth Month (1-12): ");
        month = input.nextInt();

        System.out.print("Enter your Birth Year: ");
        year = input.nextInt();

        try {
            // Create a LocalDate for the birth date
            LocalDate birthDate = LocalDate.of(year, month, day);

            // Check if the birth date is valid (not in the future)
            if (birthDate.isAfter(currentDate)) {
                System.out.println("The entered date is in the future. Please enter a valid birth date.");
            } else {
                // Calculate age
                Period age = Period.between(birthDate, currentDate);

                // Display age
                System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");

                // Determine age category
                String category;
                if (age.getYears() < 13) {
                    category = "a Kid";
                } else if (age.getYears() < 20) {
                    category = "a Teenager";
                } else if (age.getYears() < 40) {
                    category = "a Young Adult";
                } else if (age.getYears() < 60) {
                    category = "Middle-aged";
                } else {
                    category = "a Senior Citizen";
                }

                System.out.println("Based on your age, you are " + category + ".");

                // Additional message for milestones
                if (age.getYears() == 18) {
                    System.out.println("Congrats on reaching adulthood!");
                } else if (age.getYears() == 50) {
                    System.out.println("Happy Golden Jubilee of life!");
                } else if (age.getYears() == 100) {
                    System.out.println("Wow! A Centenarian! That's amazing!");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid date entered. Please ensure the values for day, month, and year are correct.");
        }

        input.close();
    }
}
