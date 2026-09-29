package chain_of_responsibility;

public class CompensationHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == Message.MessageType.COMPENSATION_CLAIM) {

            System.out.println("Compensation claim received.");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Result: Claim sent for review.");

        } else {
            super.handle(message);
        }
    }
}