package visitor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create the root directory
        System.out.print("Enter root directory name: ");
        String rootName = scanner.nextLine();

        Directory root = new Directory(rootName);

        // Add files and directories using user input
        boolean running = true;

        while (running) {

            System.out.println("\n--- File System Menu ---");
            System.out.println("1. Add File");
            System.out.println("2. Add Directory");
            System.out.println("3. Calculate Total Size");
            System.out.println("4. Search Files");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    // Add a file to a selected directory
                    Directory fileLocation =
                            chooseDirectory(scanner, root);

                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();

                    double fileSize;

                    try {
                        System.out.print("Enter file size (MB): ");
                        fileSize = Double.parseDouble(
                                scanner.nextLine()
                        );

                        if (fileSize < 0) {
                            System.out.println(
                                    "File size cannot be negative."
                            );
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid file size.");
                        break;
                    }

                    fileLocation.add(new File(fileName, fileSize));

                    System.out.println("File added successfully!");
                    break;

                case "2":
                    // Create a subdirectory
                    Directory parent =
                            chooseDirectory(scanner, root);

                    System.out.print("Enter directory name: ");
                    String directoryName = scanner.nextLine();

                    Directory newDirectory =
                            new Directory(directoryName);

                    parent.add(newDirectory);

                    System.out.println(
                            "Directory created successfully!"
                    );
                    break;

                case "3":
                    // Calculate total size using Visitor
                    SizeCalculatorVisitor sizeVisitor =
                            new SizeCalculatorVisitor();

                    root.accept(sizeVisitor);

                    System.out.println(
                            "Total file size: "
                                    + sizeVisitor.getTotalSize()
                                    + " MB"
                    );
                    break;

                case "4":
                    // Search files using Visitor
                    System.out.print(
                            "Enter file extension or name pattern: "
                    );

                    String pattern = scanner.nextLine();

                    SearchVisitor searchVisitor =
                            new SearchVisitor(pattern);

                    root.accept(searchVisitor);

                    if (searchVisitor.getMatchingFiles().isEmpty()) {

                        System.out.println("No matching files found.");

                    } else {

                        System.out.println("\nMatching files:");

                        for (File file :
                                searchVisitor.getMatchingFiles()) {

                            System.out.println(
                                    file.getName()
                                            + " - "
                                            + file.getSize()
                                            + " MB"
                            );
                        }
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }
        }

        scanner.close();
    }

    // Allow user to choose root or a nested directory
    private static Directory chooseDirectory(
            Scanner scanner, Directory root) {

        Directory current = root;

        while (true) {

            System.out.println(
                    "\nCurrent directory: " + current.getName()
            );

            System.out.println("0. Select this directory");

            int index = 1;

            // Display available subdirectories
            for (FileSystemElement element :
                    current.getElements()) {

                if (element instanceof Directory) {

                    Directory directory = (Directory) element;

                    System.out.println(
                            index + ". " + directory.getName()
                    );

                    index++;
                }
            }

            System.out.print("Choose directory: ");
            String input = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                continue;
            }

            if (choice == 0) {
                return current;
            }

            int count = 1;
            Directory selected = null;

            for (FileSystemElement element :
                    current.getElements()) {

                if (element instanceof Directory) {

                    if (count == choice) {
                        selected = (Directory) element;
                        break;
                    }

                    count++;
                }
            }

            if (selected != null) {
                current = selected;
            } else {
                System.out.println("Invalid directory number.");
            }
        }
    }
}