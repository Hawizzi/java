import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        if (name == null || name.trim().isEmpty() || age < 0) {
            throw new IllegalArgumentException("Name must not be empty and age must be non-negative.");
        }
        this.name = name.trim();
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public ArrayList<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public Book borrowBook(String title, Library library) {
        return library.borrowBook(title, this);
    }

    public boolean returnBook(Book book, Library library) {
        return library.returnBook(book, this);
    }

    void recordBorrowing(Book book) { borrowedBooks.add(book); }
    void recordReturn(Book book) { borrowedBooks.remove(book); }

    public String toString() {
        return name + ", age " + age + ", borrowed books: " + borrowedBooks.size();
    }
}
