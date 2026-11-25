
package mediator;

// Component / Colleague
public class ChatController {

    private final String username;
    private final Mediator mediator;
    private ChatWindow view;

    // Constructor
    public ChatController(String username,
                          Mediator mediator) {

        this.username = username;
        this.mediator = mediator;
    }

    // Connect controller with GUI
    public void setView(ChatWindow view) {
        this.view = view;
    }

    // Return the client's username
    public String getUsername() {
        return username;
    }

    // Send message through the mediator
    public void sendMessage(String recipient,
                            String message) {

        // Prevent empty messages
        if (recipient == null || message == null
                || message.isBlank()) {
            return;
        }

        // Prevent sending messages to yourself
        if (username.equals(recipient)) {
            return;
        }

        mediator.sendMessage(
                username, recipient, message.trim());
    }

    // Display received message
    public void receiveMessage(String sender,
                               String message) {

        view.displayMessage(
                "From " + sender + ": " + message);
    }

    // Display sent message
    public void showSentMessage(String recipient,
                                String message) {

        view.displayMessage(
                "To " + recipient + ": " + message);
    }
}
