import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Module 5.2");
            System.out.println("1. Ticket reservation system");
            System.out.println("2. Thread-safe list test");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) { return; }
            switch (scanner.nextLine().trim()) {
                case "1":
                    TicketReservationDemo.main(args);
                    break;
                case "2":
                    ThreadSafeListTester.main(args);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose a number from 0 to 2.");
                    break;
            }
            System.out.println();
        }
    }
}
