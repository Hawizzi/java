package library.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import library.model.Book;
import library.model.LibraryMember;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();
    private Map<Book, LibraryMember> loans = new HashMap<>();
    private Map<Book, LibraryMember> reservations = new HashMap<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null.");
        }
        for (Book existing : books) {
            if (existing.getIsbn().equals(book.getIsbn())) {
                return;
            }
        }
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        if (member == null) {
            throw new IllegalArgumentException("Member must not be null.");
        }
        for (LibraryMember existing : members) {
            if (existing.getMemberId() == member.getMemberId()) {
                return;
            }
        }
        members.add(member);
    }

    public List<Book> getBooks() { return new ArrayList<>(books); }
    public List<LibraryMember> getMembers() { return new ArrayList<>(members); }

    public boolean isBookAvailable(Book book) {
        return books.contains(book) && !loans.containsKey(book) && !book.isReserved();
    }

    public boolean borrowBook(LibraryMember member, Book book) {
        if (!members.contains(member) || !books.contains(book) || loans.containsKey(book)) {
            return false;
        }
        if (book.isReserved() && reservations.get(book) != member) {
            return false;
        }
        if (reservations.get(book) == member) {
            cancelReservation(member, book);
        }
        loans.put(book, member);
        member.addBorrowedBook(book);
        return true;
    }

    public boolean returnBook(LibraryMember member, Book book) {
        if (member == null || !loans.containsKey(book) || loans.get(book) != member) {
            return false;
        }
        loans.remove(book);
        member.removeBorrowedBook(book);
        return true;
    }

    public boolean reserveBook(LibraryMember member, Book book) {
        if (!members.contains(member) || !books.contains(book) || book.isReserved()
                || reservations.containsKey(book) || loans.get(book) == member) {
            return false;
        }
        reservations.put(book, member);
        book.setReserved(true);
        member.addReservedBook(book);
        return true;
    }

    public boolean cancelReservation(LibraryMember member, Book book) {
        if (member == null || !reservations.containsKey(book) || reservations.get(book) != member) {
            return false;
        }
        reservations.remove(book);
        book.setReserved(false);
        member.removeReservedBook(book);
        return true;
    }

    public void displayReservedBooks(LibraryMember member) {
        if (!members.contains(member)) {
            System.out.println("Member is not registered.");
            return;
        }
        System.out.println("Reserved books for " + member.getName() + ":");
        boolean found = false;
        for (Book book : books) {
            if (reservations.get(book) == member) {
                System.out.println(book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reserved books.");
        }
    }
}
