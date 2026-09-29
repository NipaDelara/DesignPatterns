package chain_of_responsibility;

public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == Message.MessageType.GENERAL_FEEDBACK) {

            System.out.println("General feedback received.");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Result: Feedback analyzed and response prepared.");

        } else {
            super.handle(message);
        }
    }
}