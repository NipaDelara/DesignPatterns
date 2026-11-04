package visitor;

// Represents a single file
public class File implements FileSystemElement {

    // File attributes
    private String name;
    private double size;

    // Constructor
    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    // Return file name
    public String getName() {
        return name;
    }

    // Return file size in MB
    public double getSize() {
        return size;
    }

    // Accept a visitor
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
