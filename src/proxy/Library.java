package proxy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {

    // Store document ID and document object
    private final Map<String, IDocument> documents =
            new HashMap<>();

    // Add an unprotected document
    public void addPublicDocument(String id,
                                  LocalDate date,
                                  String content) {

        Document document = new Document(id, date, content);
        documents.put(id, document);
    }

    // Add a protected document through a Proxy
    public void addProtectedDocument(String id,
                                     LocalDate date,
                                     String content) {

        Document realDocument = new Document(id, date, content);

        // Wrap the real document inside the proxy
        DocumentProxy proxy = new DocumentProxy(realDocument);

        // Store only the proxy in the library
        documents.put(id, proxy);
    }

    // Return the document or proxy using its ID
    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}
