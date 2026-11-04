package proxy;

import java.time.LocalDate;

public class DocumentProxy implements IDocument {

    // Reference to the real document
    private final Document realDocument;

    // Shared Singleton access control service
    private final AccessControlService accessControl;

    // Constructor receives the real document
    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControl = AccessControlService.getInstance();
    }

    // Document ID is always public
    @Override
    public String getId() {
        return realDocument.getId();
    }

    // Creation date is always public
    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    // Protected content requires permission
    @Override
    public String getContent(User user) {

        // Check if this user can access this document
        boolean allowed = accessControl.isAllowed(
                realDocument.getId(),
                user.getUsername()
        );

        // If not allowed, throw an exception
        if (!allowed) {
            throw new AccessDeniedException(
                    "Access denied for user: "
                            + user.getUsername()
            );
        }

        // If allowed, forward the request to real document
        return realDocument.getContent(user);
    }
}

