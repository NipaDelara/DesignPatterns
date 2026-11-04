
package proxy;

import java.time.LocalDate;

public interface IDocument {

    // Get the unique document identifier
    String getId();

    // Get the creation date (public information)
    LocalDate getCreationDate();

    // Get document content for a specific user
    String getContent(User user);
}

