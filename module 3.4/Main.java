import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 3.4");
            System.out.println("1. Network temperature CSV");
            System.out.println("2. Fibonacci CSV");
            System.out.println("3. Enrollment serialization");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) { return; }
            switch (scanner.nextLine().trim()) {
                case "1":
                    TemperatureAverage.main(args);
                    break;
                case "2":
                    FibonacciCsv.main(args);
                    break;
                case "3":
                    EnrollmentDemo.main(args);
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
}
