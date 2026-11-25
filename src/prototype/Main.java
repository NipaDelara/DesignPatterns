package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Scanner for user input
    private static final Scanner scanner =
            new Scanner(System.in);

    // Store all saved recommendations
    private static final List<Recommendation>
            recommendations = new ArrayList<>();

    public static void main(String[] args) {

        // Create an initial recommendation
        Recommendation original =
                new Recommendation("University Students");

        original.addBook(new Book(
                "Robert C. Martin",
                "Clean Code",
                "Programming",
                2008
        ));

        original.addBook(new Book(
                "Joshua Bloch",
                "Effective Java",
                "Programming",
                2018
        ));

        // Save the initial recommendation
        recommendations.add(original);

        boolean running = true;

        // Main menu loop
        while (running) {

            System.out.println(
                    "\n===== BOOK RECOMMENDATION SYSTEM ====="
            );

            System.out.println("1. View recommendations");
            System.out.println("2. Create recommendation");
            System.out.println("3. Clone recommendation");
            System.out.println("4. Modify recommendation");
            System.out.println("5. Exit");

            int choice = readInt("Choose an option: ");

            switch (choice) {

                case 1:
                    viewRecommendations();
                    break;

                case 2:
                    createRecommendation();
                    break;

                case 3:
                    cloneRecommendation();
                    break;

                case 4:
                    modifyRecommendation();
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // Display all saved recommendations
    private static void viewRecommendations() {

        if (recommendations.isEmpty()) {
            System.out.println("No recommendations found.");
            return;
        }

        for (int i = 0; i < recommendations.size(); i++) {

            System.out.println(
                    "\nRecommendation " + (i + 1)
            );

            recommendations.get(i).displayBooks();
        }
    }

    // Create a new recommendation from scratch
    private static void createRecommendation() {

        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();

        Recommendation recommendation =
                new Recommendation(audience);

        // Allow the user to add books
        editRecommendation(recommendation);

        // Save the new recommendation
        recommendations.add(recommendation);

        System.out.println(
                "New recommendation saved successfully."
        );
    }

    // Select an existing recommendation
    private static Recommendation selectRecommendation() {

        if (recommendations.isEmpty()) {
            System.out.println("No recommendations found.");
            return null;
        }

        viewRecommendations();

        int index = readInt(
                "\nSelect recommendation number: "
        ) - 1;

        if (index < 0 || index >= recommendations.size()) {

            System.out.println("Invalid recommendation.");
            return null;
        }

        return recommendations.get(index);
    }

    // Clone an existing recommendation
    private static void cloneRecommendation() {

        Recommendation original =
                selectRecommendation();

        if (original == null) {
            return;
        }

        // Prototype pattern: deep cloning
        Recommendation cloned = original.clone();

        System.out.println(
                "Recommendation cloned successfully."
        );

        // Modify the cloned recommendation
        editRecommendation(cloned);

        // Save the clone as a new recommendation
        recommendations.add(cloned);

        System.out.println(
                "Cloned recommendation saved successfully."
        );
    }

    // Modify an existing recommendation
    private static void modifyRecommendation() {

        Recommendation recommendation =
                selectRecommendation();

        if (recommendation != null) {

            editRecommendation(recommendation);

            System.out.println("Changes saved successfully.");
        }
    }

    // Menu for editing a recommendation
    private static void editRecommendation(
            Recommendation recommendation) {

        boolean editing = true;

        while (editing) {

            System.out.println(
                    "\n===== MODIFY RECOMMENDATION ====="
            );

            System.out.println("1. Change target audience");
            System.out.println("2. Add book");
            System.out.println("3. Remove book");
            System.out.println("4. Edit book title");
            System.out.println("5. View books");
            System.out.println("6. Save and return");

            int choice = readInt("Choose an option: ");

            switch (choice) {

                case 1:

                    System.out.print("Enter new audience: ");

                    recommendation.setTargetAudience(
                            scanner.nextLine()
                    );

                    break;

                case 2:

                    recommendation.addBook(readBook());

                    System.out.println(
                            "Book added successfully."
                    );

                    break;

                case 3:

                    recommendation.displayBooks();

                    int removeIndex = readInt(
                            "Enter book number to remove: "
                    ) - 1;

                    recommendation.removeBook(removeIndex);

                    break;

                case 4:

                    recommendation.displayBooks();

                    int editIndex = readInt(
                            "Enter book number to edit: "
                    ) - 1;

                    if (editIndex >= 0 &&
                            editIndex <
                                    recommendation.getBookCount()) {

                        System.out.print("Enter new title: ");

                        recommendation.getBook(editIndex)
                                .setTitle(scanner.nextLine());

                        System.out.println("Title updated.");

                    } else {

                        System.out.println(
                                "Invalid book number."
                        );
                    }

                    break;

                case 5:

                    recommendation.displayBooks();
                    break;

                case 6:

                    editing = false;
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }

    // Read book information from the user
    private static Book readBook() {

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        int year = readInt("Enter publication year: ");

        return new Book(author, title, genre, year);
    }

    // Safely read integer input
    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}