import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 2.3 - Tasks 1-6 completed");
            System.out.println("1. Library and books");
            System.out.println("2. Book borrowing");
            System.out.println("3. Book availability");
            System.out.println("4. Ratings and reviews");
            System.out.println("5. Library statistics");
            System.out.println("6. Library users");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                return;
            }
            try {
                int task = Integer.parseInt(choice);
                if (task >= 1 && task <= 6) {
                    LibraryMain.runTask(task);
                } else {
                    System.out.println("Please choose a number from 0 to 6.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please choose a number from 0 to 6.");
            }
            System.out.println();
        }
    }
}
