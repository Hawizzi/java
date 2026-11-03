import java.util.Scanner;
import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 3.3");
            System.out.println("1. Bank accounts");
            System.out.println("2. Library packages");
            System.out.println("3. Book reservations");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            switch (scanner.nextLine().trim()) {
                case "1":
                    BankAccount.main(args);
                    break;
                case "2":
                    demonstrateLibrary(false);
                    break;
                case "3":
                    demonstrateLibrary(true);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose a number from 0 to 3.");
                    break;
            }
            System.out.println();
        }
    }

    public static void demonstrateLibrary(boolean showReservations) {
        Library library = new Library();
        Book java = new Book("Introduction to Java", "John Smith", "9780134685991");
        Book algorithms = new Book("Algorithms", "Jane Doe", "9780262033848");
        LibraryMember alice = new LibraryMember("Alice", 1);
        LibraryMember bob = new LibraryMember("Bob", 2);
        library.addBook(java);
        library.addBook(algorithms);
        library.addMember(alice);
        library.addMember(bob);

        if (!showReservations) {
            System.out.println("Library books:");
            for (Book book : library.getBooks()) {
                System.out.println(book);
            }
            System.out.println("Registered members: " + library.getMembers().size());
            System.out.println("Alice borrowed Java: " + library.borrowBook(alice, java));
            System.out.println("Alice's borrowed books:");
            for (Book book : alice.getBorrowedBooks()) {
                System.out.println(book.getTitle());
            }
            System.out.println("Java available: " + library.isBookAvailable(java));
            System.out.println("Alice returned Java: " + library.returnBook(alice, java));
            System.out.println("Java available after return: " + library.isBookAvailable(java));
        } else {
            System.out.println("Alice reserved Java: " + library.reserveBook(alice, java));
            System.out.println("Java marked reserved: " + java.isReserved());
            library.displayReservedBooks(alice);
            System.out.println("Bob can borrow Alice's reserved book: " + library.borrowBook(bob, java));
            System.out.println("Bob can cancel Alice's reservation: " + library.cancelReservation(bob, java));
            System.out.println("Alice canceled reservation: " + library.cancelReservation(alice, java));
            library.displayReservedBooks(alice);
            System.out.println("Bob reserved Algorithms: " + library.reserveBook(bob, algorithms));
            library.displayReservedBooks(bob);
            System.out.println("Bob borrowed his reserved book: " + library.borrowBook(bob, algorithms));
            System.out.println("Algorithms marked reserved after borrowing: " + algorithms.isReserved());
            library.displayReservedBooks(bob);
        }
    }
}
