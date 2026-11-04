package proxy;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Step 1: Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 2: Create library
        Library library = new Library();

        // Step 3: Add public document
        library.addPublicDocument(
                "DOC1",
                LocalDate.of(2026, 11, 1),
                "Welcome to the public library!"
        );

        // Step 4: Add protected documents
        library.addProtectedDocument(
                "DOC2",
                LocalDate.of(2026, 11, 2),
                "Confidential company information."
        );

        library.addProtectedDocument(
                "DOC3",
                LocalDate.of(2026, 11, 3),
                "Private employee salary information."
        );

        // Step 5: Configure document permissions
        AccessControlService access =
                AccessControlService.getInstance();

        access.grantAccess("Alice", "DOC2");
        access.grantAccess("Bob", "DOC3");

        // Step 6: Ask user for username
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();

        User user = new User(username);

        // Step 7: Display document menu
        while (true) {

            System.out.println("\n===== DOCUMENT LIBRARY =====");
            System.out.println("1. DOC1 - Public Document");
            System.out.println("2. DOC2 - Protected Document");
            System.out.println("3. DOC3 - Protected Document");
            System.out.println("0. Exit");

            System.out.print("Choose a document: ");
            String choice = scanner.nextLine().trim();

            // Exit program
            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            String documentId;

            // Step 8: Convert menu choice to document ID
            switch (choice) {
                case "1":
                    documentId = "DOC1";
                    break;

                case "2":
                    documentId = "DOC2";
                    break;

                case "3":
                    documentId = "DOC3";
                    break;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            // Step 9: Get document from library
            IDocument document =
                    library.getDocument(documentId);

            // Step 10: Display public information
            System.out.println("\nDocument ID: "
                    + document.getId());

            System.out.println("Creation Date: "
                    + document.getCreationDate());

            // Step 11: Access content through Proxy
            try {
                String content = document.getContent(user);

                System.out.println("Content: " + content);

            } catch (AccessDeniedException e) {
                System.out.println(e.getMessage());
            }
        }

        // Step 12: Close Scanner
        scanner.close();
    }
}
