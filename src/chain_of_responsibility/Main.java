package chain_of_responsibility;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creates scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Creates the feedback handlers
        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler developmentHandler = new DevelopmentSuggestionHandler();
        Handler generalHandler = new GeneralFeedbackHandler();

        // Creates the Chain of Responsibility
        compensationHandler
                .setNextHandler(contactHandler)
                .setNextHandler(developmentHandler)
                .setNextHandler(generalHandler);

        System.out.println("=== Customer Feedback System ===");

        // Shows feedback options
        System.out.println("\nChoose feedback type:");
        System.out.println("1. Compensation Claim");
        System.out.println("2. Contact Request");
        System.out.println("3. Development Suggestion");
        System.out.println("4. General Feedback");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Gets sender email
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        // Gets feedback message
        System.out.print("Enter your message: ");
        String content = scanner.nextLine();

        Message.MessageType type;

        // Converts user choice to message type
        switch (choice) {
            case 1:
                type = Message.MessageType.COMPENSATION_CLAIM;
                break;

            case 2:
                type = Message.MessageType.CONTACT_REQUEST;
                break;

            case 3:
                type = Message.MessageType.DEVELOPMENT_SUGGESTION;
                break;

            case 4:
                type = Message.MessageType.GENERAL_FEEDBACK;
                break;

            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        // Creates message from user input
        Message message = new Message(type, content, email);

        System.out.println("\n=== Feedback Result ===");

        // Sends message through the handler chain
        compensationHandler.handle(message);

        scanner.close();
    }
}