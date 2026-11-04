package visitor;

import java.util.ArrayList;
import java.util.List;

// Represents a folder in the file system
public class Directory implements FileSystemElement {

    private final String name;

    // Store files and subdirectories
    private final List<FileSystemElement> elements;

    // Constructor
    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    // Return directory name
    public String getName() {
        return name;
    }

    // Add a file or subdirectory
    public void add(FileSystemElement element) {
        elements.add(element);
    }

    // Return directory contents
    public List<FileSystemElement> getElements() {
        return elements;
    }

    // Accept a visitor
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
