import java.util.Scanner;

public class MultiThreadedNumberPrinting {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        while (true) {
            System.out.println("Enter start and end integers, separated by a space:");
            if (!scanner.hasNextLine()) { return; }
            String[] values = scanner.nextLine().trim().split("\\s+");
            try {
                if (values.length != 2) { throw new NumberFormatException(); }
                int start = Integer.parseInt(values[0]);
                int end = Integer.parseInt(values[1]);
                if (start > end) {
                    System.out.println("Start must not be greater than end.");
                    continue;
                }
                printRange(start, end);
                return;
            } catch (NumberFormatException exception) {
                System.out.println("Please enter two valid integers.");
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                System.out.println("Printing interrupted.");
                return;
            }
        }
    }

    public static void printRange(int start, int end) throws InterruptedException {
        NumberPrinter printer = new NumberPrinter(start, end);
        Thread oddThread = new Thread(() -> printer.printNumbers(true), "Odd Thread");
        Thread evenThread = new Thread(() -> printer.printNumbers(false), "Even Thread");
        oddThread.start();
        evenThread.start();
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException exception) {
            oddThread.interrupt();
            evenThread.interrupt();
            throw exception;
        }
        System.out.println("Printing complete.");
    }
}
