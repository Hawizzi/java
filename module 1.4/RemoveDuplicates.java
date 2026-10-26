import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        int size;
        while (true) {
            System.out.println("Enter the size of the array:");
            try {
                size = Integer.parseInt(scanner.nextLine().trim());
                if (size >= 0) {
                    break;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Please enter a non-negative integer.");
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

        int[] uniqueNumbers = new int[numbers.length];
        int uniqueCount = 0;
        for (int number : numbers) {
            boolean duplicate = false;
            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueNumbers[i] == number) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                uniqueNumbers[uniqueCount] = number;
                uniqueCount++;
            }
        }

        System.out.println("The array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(uniqueNumbers[i]);
        }
        System.out.println();
    }
}
