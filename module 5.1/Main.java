import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Module 5.1");
            System.out.println("1. Multi-threaded number printing");
            System.out.println("2. Parallel number summation");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) { return; }
            switch (scanner.nextLine().trim()) {
                case "1":
                    MultiThreadedNumberPrinting.run(scanner);
                    break;
                case "2":
                    ParallelNumberSummation.main(args);
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
