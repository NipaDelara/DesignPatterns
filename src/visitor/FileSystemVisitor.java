package visitor;
// Visitor interface
public interface FileSystemVisitor {

    // Visit a single file
    void visit(File file);

    // Visit a directory
    void visit(Directory directory);
}