package proxy;

import java.time.LocalDate;

public class Document implements IDocument {

    // Document information
    private final String id;
    private final LocalDate creationDate;
    private final String content;

    // Constructor to create a real document
    public Document(String id, LocalDate creationDate,
                    String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    // Return document identifier
    @Override
    public String getId() {
        return id;
    }

    // Return document creation date
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    // Return actual document content
    // Access control is handled by DocumentProxy
    @Override
    public String getContent(User user) {
        return content;
    }
}
