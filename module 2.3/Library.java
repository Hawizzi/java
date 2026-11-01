import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<Book, User> loans = new HashMap<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null.");
        }
        if (!books.contains(book) && !loans.containsKey(book)) {
            books.add(book);
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void findBooksByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (author != null && book.getAuthor().equalsIgnoreCase(author.trim())) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    public Book borrowBook(String title) {
        return borrowBook(title, null);
    }

    public Book borrowBook(String title, User user) {
        if (user != null && !users.contains(user)) {
            return null;
        }
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (title != null && book.getTitle().equalsIgnoreCase(title.trim())) {
                books.remove(i);
                loans.put(book, user);
                if (user != null) {
                    user.recordBorrowing(book);
                }
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        if (loans.containsKey(book)) {
            completeReturn(book);
        }
    }

    public boolean returnBook(Book book, User user) {
        if (user == null || !loans.containsKey(book) || loans.get(book) != user) {
            return false;
        }
        completeReturn(book);
        return true;
    }

    private void completeReturn(Book book) {
        User borrower = loans.remove(book);
        if (borrower != null) {
            borrower.recordReturn(book);
        }
        books.add(book);
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (title != null && book.getTitle().equalsIgnoreCase(title.trim())) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Book book : books) {
            total += book.getRating();
        }
        return total / books.size();
    }

    public Book getMostReviewedBook() {
        Book mostReviewed = null;
        for (Book book : books) {
            if (mostReviewed == null || book.getReviewCount() > mostReviewed.getReviewCount()) {
                mostReviewed = book;
            }
        }
        return mostReviewed;
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null.");
        }
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public boolean removeUser(User user) {
        if (loans.containsValue(user)) {
            return false;
        }
        return users.remove(user);
    }

    public User findUser(String name) {
        for (User user : users) {
            if (name != null && user.getName().equalsIgnoreCase(name.trim())) {
                return user;
            }
        }
        return null;
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No registered users.");
        }
        for (User user : users) {
            System.out.println(user);
            for (Book book : loans.keySet()) {
                if (loans.get(book) == user) {
                    System.out.println("  Borrowed: " + book.getTitle());
                }
            }
        }
    }
}
