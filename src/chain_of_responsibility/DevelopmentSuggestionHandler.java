package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == Message.MessageType.DEVELOPMENT_SUGGESTION) {

            System.out.println("Development suggestion received.");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Result: Suggestion logged for development.");

        } else {
            super.handle(message);
        }
    }
}