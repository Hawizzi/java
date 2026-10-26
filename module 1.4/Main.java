import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Module 1.4");
            System.out.println("1. Name generator");
            System.out.println("2. Maximum subarray sum");
            System.out.println("3. Remove duplicates");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");

            if (!scanner.hasNextLine()) {
                return;
            }

            switch (scanner.nextLine().trim()) {
                case "1":
                    NameGenerator.run(scanner);
                    break;
                case "2":
                    MaximumSubarraySum.run(scanner);
                    break;
                case "3":
                    RemoveDuplicates.run(scanner);
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
