package chain_of_responsibility;

public abstract class Handler {

    private Handler nextHandler;

    // Sets the next handler in the chain
    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    // Passes the message to the next handler
    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}