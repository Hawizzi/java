import java.util.Scanner;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        int size;
        while (true) {
            System.out.println("Enter the size of the array:");
            try {
                size = Integer.parseInt(scanner.nextLine().trim());
                if (size > 0) {
                    break;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Please enter a positive integer.");
        }

        int[] numbers = new int[size];
        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                System.out.println("Enter integer " + (i + 1) + ":");
                try {
                    numbers[i] = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid integer.");
                }
            }
        }

        long maximumSum = Long.MIN_VALUE;
        int maximumStart = 0;
        int maximumEnd = 0;

        for (int start = 0; start < numbers.length; start++) {
            long sum = 0;
            for (int end = start; end < numbers.length; end++) {
                sum += numbers[end];
                if (sum > maximumSum) {
                    maximumSum = sum;
                    maximumStart = start;
                    maximumEnd = end;
                }
            }
        }

        System.out.println("Maximum sum: " + maximumSum);
        System.out.println("Integers: " + (maximumStart + 1) + "-" + (maximumEnd + 1));
    }
}
