package proxy;

public class AccessDeniedException
        extends RuntimeException {

    // Exception message when access is denied
    public AccessDeniedException(String message) {
        super(message);
    }
}

