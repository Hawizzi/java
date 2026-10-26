import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        int start;
        int end;

        while (true) {
            System.out.println("Enter two positive integers, start and end (start < end):");
            String[] values = scanner.nextLine().trim().split("\\s+");
            try {
                if (values.length != 2) {
                    throw new NumberFormatException();
                }
                start = Integer.parseInt(values[0]);
                end = Integer.parseInt(values[1]);
                if (start > 0 && start < end) {
                    break;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Invalid range. Use positive integers with start < end.");
        }

        System.out.println("Prime numbers between " + start + " and " + end + ":");
        boolean found = false;
        for (long number = Math.max(2, start); number <= end; number++) {
            boolean prime = true;
            for (long divisor = 2; divisor * divisor <= number; divisor++) {
                if (number % divisor == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(number);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prime numbers in this range.");
        }
    }
}

