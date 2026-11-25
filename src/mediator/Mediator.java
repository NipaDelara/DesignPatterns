package mediator;

// Defines the communication rules
public interface Mediator {

    // Register a new chat client
    void registerClient(ChatController client);

    // Send a message through the mediator
    void sendMessage(String sender,
                     String recipient,
                     String message);
}
