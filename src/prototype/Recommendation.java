package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation
        implements Prototype<Recommendation> {

    // Target reader group
    private String targetAudience;

    // List of recommended books
    private final List<Book> books;

    // Constructor
    public Recommendation(String targetAudience) {

        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // Get target audience
    public String getTargetAudience() {
        return targetAudience;
    }

    // Change target audience
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    // Add a book to the recommendation
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book using its index
    public void removeBook(int index) {

        if (index >= 0 && index < books.size()) {
            books.remove(index);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    // Return the number of books
    public int getBookCount() {
        return books.size();
    }

    // Get a specific book
    public Book getBook(int index) {
        return books.get(index);
    }

    // Display all recommended books
    public void displayBooks() {

        System.out.println("\nTarget Audience: "
                + targetAudience);

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + books.get(i)
            );
        }
    }

    // Deep clone of the recommendation
    @Override
    public Recommendation clone() {

        // Create a new recommendation object
        Recommendation copy =
                new Recommendation(this.targetAudience);

        // Clone every individual Book object
        for (Book book : this.books) {

            copy.addBook(book.clone());
        }

        // Return the independent recommendation
        return copy;
    }
}