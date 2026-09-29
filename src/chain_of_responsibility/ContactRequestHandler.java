package chain_of_responsibility;

public class ContactRequestHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == Message.MessageType.CONTACT_REQUEST) {

            System.out.println("Contact request received.");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Result: Forwarded to customer service.");

        } else {
            super.handle(message);
        }
    }
}