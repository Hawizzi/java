package library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private final String name;
    private final int memberId;
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> reservedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        if (name == null || name.trim().isEmpty() || memberId <= 0) {
            throw new IllegalArgumentException("Name must not be empty and member ID must be positive.");
        }
        this.name = name.trim();
        this.memberId = memberId;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    public List<Book> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }
    public List<Book> getReservedBooks() { return new ArrayList<>(reservedBooks); }

    public void addBorrowedBook(Book book) {
        if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
        }
    }

    public void removeBorrowedBook(Book book) { borrowedBooks.remove(book); }
    public boolean hasBorrowedBook(Book book) { return borrowedBooks.contains(book); }

    public void addReservedBook(Book book) {
        if (book != null && !reservedBooks.contains(book)) {
            reservedBooks.add(book);
        }
    }

    public void removeReservedBook(Book book) { reservedBooks.remove(book); }
    public boolean hasReservedBook(Book book) { return reservedBooks.contains(book); }
}
