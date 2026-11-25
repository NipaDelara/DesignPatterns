
package mediator;

import java.util.HashMap;
import java.util.Map;

// Concrete Mediator
public class ChatMediator implements Mediator {

    // Stores all registered clients
    private final Map<String, ChatController> clients =
            new HashMap<>();

    @Override
    public void registerClient(ChatController client) {

        // Prevent duplicate usernames
        if (clients.containsKey(client.getUsername())) {
            throw new IllegalArgumentException(
                    "Username already exists");
        }

        // Add client to the map
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender,
                            String recipient,
                            String message) {

        // Find the recipient
        ChatController receiver = clients.get(recipient);

        // Find the sender
        ChatController senderClient = clients.get(sender);

        // Check if both clients exist
        if (receiver != null && senderClient != null) {

            // Deliver message to the recipient
            receiver.receiveMessage(sender, message);

            // Display sent message in sender's window
            senderClient.showSentMessage(recipient, message);
        }
    }
}
