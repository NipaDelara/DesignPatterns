package chain_of_responsibility;


// Represents a customer feedback message
public class Message {

    // Defines the different feedback types
    public enum MessageType {
        COMPENSATION_CLAIM,
        CONTACT_REQUEST,
        DEVELOPMENT_SUGGESTION,
        GENERAL_FEEDBACK
    }

    private final MessageType type;
    private final String content;
    private final String senderEmail;

    // Creates a new feedback message
    public Message(MessageType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    // Returns the message type
    public MessageType getType() {
        return type;
    }

    // Returns the message content
    public String getContent() {
        return content;
    }

    // Returns the sender email
    public String getSenderEmail() {
        return senderEmail;
    }
}