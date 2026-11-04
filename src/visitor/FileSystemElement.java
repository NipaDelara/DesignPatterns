package visitor;

// Common interface for File and Directory
public interface FileSystemElement {

    // Accept a visitor to perform an operation
    void accept(FileSystemVisitor visitor);
}