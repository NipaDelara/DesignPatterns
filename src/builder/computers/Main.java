package builder.computers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Keep showing the menu until the user exits
        while (true) {

            System.out.println("\n=== COMPUTER BUILDER ===");
            System.out.println("1. Gaming Computer");
            System.out.println("2. Office Computer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Validate user input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            // Exit the program
            if (choice == 3) {
                System.out.println("Thank you!");
                break;
            }

            ComputerBuilder builder;

            // Select the appropriate builder
            if (choice == 1) {
                builder = new GamingComputerBuilder();

            } else if (choice == 2) {
                builder = new OfficeComputerBuilder();

            } else {
                System.out.println("Invalid choice!");
                continue;
            }

            // Create the Director
            ComputerDirector director =
                    new ComputerDirector(builder);

            // Build the selected computer
            director.constructComputer();

            // Get the final product
            Computer computer = builder.getComputer();

            // Display the result
            System.out.println("\n=== COMPUTER CONFIGURATION ===");
            System.out.println(computer);
        }

        scanner.close();
    }
}