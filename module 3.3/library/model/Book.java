package library.model;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean reserved;

    public Book(String title, String author, String isbn) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()
                || isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("Title, author and ISBN must not be empty.");
        }
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isReserved() { return reserved; }
    public void setReserved(boolean reserved) { this.reserved = reserved; }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
