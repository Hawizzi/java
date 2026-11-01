import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 2.2");
            System.out.println("1. Grocery list manager");
            System.out.println("2. Total cost calculation");
            System.out.println("3. Categorizing items");
            System.out.println("4. Quantity tracking");
            System.out.println("5. Grocery list tester");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            switch (scanner.nextLine().trim()) {
                case "1":
                    GroceryListTester.demonstrateBasicList();
                    break;
                case "2":
                    GroceryListTester.demonstrateTotalCost();
                    break;
                case "3":
                    GroceryListTester.demonstrateCategories();
                    break;
                case "4":
                    GroceryListTester.demonstrateQuantities();
                    break;
                case "5":
                    GroceryListTester.demonstrateAllFeatures();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose a number from 0 to 5.");
                    break;
            }
            System.out.println();
        }
    }
}
