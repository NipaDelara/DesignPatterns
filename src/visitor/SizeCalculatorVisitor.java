package visitor;

// Visitor for calculating total file size
public class SizeCalculatorVisitor
        implements FileSystemVisitor {

    // Store accumulated size in MB
    private double totalSize = 0;

    // Visit a file and add its size
    @Override
    public void visit(File file) {

        totalSize += file.getSize();
    }

    // Visit all elements inside a directory
    @Override
    public void visit(Directory directory) {

        for (FileSystemElement element
                : directory.getElements()) {

            // Visit each file or subdirectory
            element.accept(this);
        }
    }

    // Return the total calculated size
    public double getTotalSize() {
        return totalSize;
    }
}