public class LibraryMain {
    public static void main(String[] args) {
        for (int task = 1; task <= 6; task++) {
            runTask(task);
            System.out.println();
        }
    }

    public static void runTask(int task) {
        Library library = new Library();
        Book java = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book algorithms = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book fiction = new Book("The Art of Fiction", "Alice Johnson", 2019);
        library.addBook(java);
        library.addBook(algorithms);
        library.addBook(fiction);

        switch (task) {
            case 1:
                System.out.println("Library Catalog:");
                library.displayBooks();
                System.out.println();
                System.out.println("Books by Author \"Jane Doe\":");
                library.findBooksByAuthor("Jane Doe");
                break;
            case 2:
                Book borrowed = library.borrowBook(java.getTitle());
                System.out.println("Borrowed: " + borrowed.getTitle());
                System.out.println("Available books after borrowing:");
                library.displayBooks();
                library.returnBook(borrowed);
                System.out.println("Available books after returning:");
                library.displayBooks();
                break;
            case 3:
                System.out.println("Available before borrowing: " + library.isBookAvailable(java.getTitle()));
                library.borrowBook(java.getTitle());
                System.out.println("Available after borrowing: " + library.isBookAvailable(java.getTitle()));
                library.returnBook(java);
                System.out.println("Available after returning: " + library.isBookAvailable(java.getTitle()));
                break;
            case 4:
                java.setRating(4.5);
                java.addReview("A clear introduction to Java.");
                java.addReview("Useful examples for beginners.");
                System.out.println("Book: " + java.getTitle());
                System.out.println("Rating: " + java.getRating() + "/5");
                System.out.println("Reviews:");
                for (String review : java.getReviews()) {
                    System.out.println(review);
                }
                break;
            case 5:
                java.setRating(4.5);
                algorithms.setRating(5);
                fiction.setRating(4);
                java.addReview("Clear examples.");
                algorithms.addReview("Excellent explanations.");
                algorithms.addReview("Very useful reference.");
                System.out.println("Average book rating: " + library.getAverageBookRating());
                Book mostReviewed = library.getMostReviewedBook();
                System.out.println("Most reviewed book: " + mostReviewed.getTitle());
                System.out.println("Number of reviews: " + mostReviewed.getReviewCount());
                break;
            case 6:
                User alice = new User("Alice", 25);
                User bob = new User("Bob", 30);
                library.addUser(alice);
                library.addUser(bob);
                alice.borrowBook(java.getTitle(), library);
                bob.borrowBook(algorithms.getTitle(), library);
                System.out.println("Library users and their loans:");
                library.displayUsers();
                System.out.println("Found user: " + library.findUser("Alice").getName());
                System.out.println("Removing Alice with an active loan: " + library.removeUser(alice));
                System.out.println("Alice returned her book: " + alice.returnBook(java, library));
                System.out.println("Removing Alice after return: " + library.removeUser(alice));
                System.out.println("Remaining users:");
                library.displayUsers();
                break;
            default:
                throw new IllegalArgumentException("Task must be between 1 and 6.");
        }
    }
}
