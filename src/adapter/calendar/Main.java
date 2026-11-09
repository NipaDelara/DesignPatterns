
package adapter.calendar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Client uses the Target interface
        NewDateInterface date =
                new CalendarToNewDateAdapter();

        System.out.println("=== Calendar Adapter ===");

        try {
            // Read date from user
            System.out.print("Enter year: ");
            int year = scanner.nextInt();

            System.out.print("Enter month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Enter day: ");
            int day = scanner.nextInt();

            // Set the complete date
            date.setYear(year);
            date.setMonth(month);
            date.setDay(day);

            // Display the date using getter methods
            System.out.printf(
                    "Original date: %02d/%02d/%04d%n",
                    date.getDay(),
                    date.getMonth(),
                    date.getYear()
            );

            // Ask how many days to advance
            System.out.print("Enter days to advance: ");
            int days = scanner.nextInt();

            // Advance the date
            date.advanceDays(days);

            // Display updated date
            System.out.printf(
                    "New date: %02d/%02d/%04d%n",
                    date.getDay(),
                    date.getMonth(),
                    date.getYear()
            );

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter whole numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid date or day value.");
        } finally {
            scanner.close();
        }
    }
}

