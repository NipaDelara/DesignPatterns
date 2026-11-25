package prototype;

public class Book implements Prototype<Book> {

    // Book attributes
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    // Constructor to initialize a book
    public Book(String author, String title,
                String genre, int publicationYear) {

        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Setters allow book information to be modified
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Prototype method: creates an independent Book object
    @Override
    public Book clone() {

        return new Book(
                author,
                title,
                genre,
                publicationYear
        );
    }

    // Returns book information as readable text
    @Override
    public String toString() {

        return title + " by " + author
                + " | Genre: " + genre
                + " | Year: " + publicationYear;
    }
}