import java.util.Locale;

public class GroceryListTester {
    public static void main(String[] args) {
        demonstrateAllFeatures();
    }

    public static void demonstrateBasicList() {
        GroceryListManager manager = new GroceryListManager();
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");
        System.out.println("Grocery List:");
        manager.displayList();
        System.out.println();
        System.out.println("Is \"Milk\" in the grocery list? " + manager.checkItem("Milk"));
        System.out.println();
        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");
        System.out.println();
        System.out.println("Updated Grocery List:");
        manager.displayList();
    }

    public static void demonstrateTotalCost() {
        GroceryListManager manager = new GroceryListManager();
        manager.addItem("Apples", 2.50);
        manager.addItem("Milk", 1.80);
        manager.addItem("Bread", 3.20);
        manager.displayList();
        System.out.printf(Locale.US, "Total cost: %.2f%n", manager.calculateTotalCost());
    }

    public static void demonstrateCategories() {
        GroceryListManager manager = new GroceryListManager();
        manager.addItem("Apples", 2.50, "Fruits");
        manager.addItem("Bananas", 1.50, "Fruits");
        manager.addItem("Milk", 1.80, "Dairy");
        manager.addItem("Bread", 3.20, "Bakery");
        System.out.println("Fruits:");
        manager.displayByCategory("Fruits");
        System.out.println("Dairy:");
        manager.displayByCategory("Dairy");
        System.out.println("Bakery:");
        manager.displayByCategory("Bakery");
    }

    public static void demonstrateQuantities() {
        GroceryListManager manager = new GroceryListManager();
        manager.addItem("Apples", 2.50, "Fruits", 3);
        manager.addItem("Milk", 1.80, "Dairy", 2);
        manager.addItem("Bread", 3.20, "Bakery", 0);
        System.out.println("Available items:");
        manager.displayAvailableItems();
        System.out.println("Updating Apples to 5 and Milk to 0...");
        manager.updateQuantity("Apples", 5);
        manager.updateQuantity("Milk", 0);
        System.out.println("Available items after updates:");
        manager.displayAvailableItems();
    }

    public static void demonstrateAllFeatures() {
        GroceryListManager manager = new GroceryListManager();
        manager.addItem("Apples", 2.50, "Fruits", 3);
        manager.addItem("Bananas", 1.50, "Fruits", 2);
        manager.addItem("Milk", 1.80, "Dairy", 2);
        manager.addItem("Bread", 3.20, "Bakery", 0);
        System.out.println("Grocery List:");
        manager.displayList();
        System.out.printf(Locale.US, "Total cost: %.2f%n", manager.calculateTotalCost());
        System.out.println("Fruits:");
        manager.displayByCategory("Fruits");
        System.out.println("Dairy:");
        manager.displayByCategory("Dairy");
        System.out.println("Bakery:");
        manager.displayByCategory("Bakery");
        System.out.println("Available items:");
        manager.displayAvailableItems();
        System.out.println("Updating Apples to 5 and Milk to 0...");
        manager.updateQuantity("Apples", 5);
        manager.updateQuantity("Milk", 0);
        System.out.println("Available items after updates:");
        manager.displayAvailableItems();
        System.out.printf(Locale.US, "Updated total cost: %.2f%n", manager.calculateTotalCost());
    }
}
