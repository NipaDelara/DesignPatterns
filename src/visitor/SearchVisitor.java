package visitor;

import java.util.ArrayList;
import java.util.List;

// Visitor for searching files
public class SearchVisitor implements FileSystemVisitor {

    // Text to search in file names
    private final String searchPattern;

    // Store matching files
    private final List<File> matchingFiles;

    // Constructor
    public SearchVisitor(String searchPattern) {

        this.searchPattern = searchPattern.toLowerCase();

        this.matchingFiles = new ArrayList<>();
    }

    // Check if a file matches the search
    @Override
    public void visit(File file) {

        String fileName = file.getName().toLowerCase();

        if (fileName.contains(searchPattern)) {

            matchingFiles.add(file);
        }
    }

    // Search inside directories
    @Override
    public void visit(Directory directory) {

        for (FileSystemElement element
                : directory.getElements()) {

            // Visit files and nested directories
            element.accept(this);
        }
    }

    // Return matching files
    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}