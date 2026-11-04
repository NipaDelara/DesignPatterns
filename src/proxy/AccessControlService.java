package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    // Create one shared Singleton instance
    private static final AccessControlService instance =
            new AccessControlService();

    // Store allowed username and document ID pairs
    private final Set<String> permissions = new HashSet<>();

    // Private constructor prevents external object creation
    private AccessControlService() {
    }

    // Return the shared Singleton instance
    public static AccessControlService getInstance() {
        return instance;
    }

    // Create a unique key for user and document
    private String createKey(String username, String documentId) {
        return username.length() + ":" + username + documentId;
    }

    // Give a user permission to access a document
    public void grantAccess(String username, String documentId) {
        permissions.add(createKey(username, documentId));
    }

    // Check if the user is allowed to access the document
    public boolean isAllowed(String documentId, String username) {
        return permissions.contains(createKey(username, documentId));
    }
}
