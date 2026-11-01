import java.util.ArrayList;
import java.util.HashMap;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();
    private HashMap<String, Double> costs = new HashMap<>();
    private HashMap<String, String> categories = new HashMap<>();
    private HashMap<String, Integer> quantities = new HashMap<>();

    public void addItem(String item) {
        addItem(item, 0, "Uncategorized", 1);
    }

    public void addItem(String item, double cost) {
        addItem(item, cost, "Uncategorized", 1);
    }

    public void addItem(String item, double cost, String category) {
        addItem(item, cost, category, 1);
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (item == null || item.trim().isEmpty() || category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Item and category must not be empty.");
        }
        if (!Double.isFinite(cost) || cost < 0 || quantity < 0) {
            throw new IllegalArgumentException("Cost and quantity must be non-negative and cost must be finite.");
        }
        item = item.trim();
        if (groceryList.contains(item)) {
            return;
        }
        groceryList.add(item);
        costs.put(item, cost);
        categories.put(item, category.trim());
        quantities.put(item, quantity);
    }

    public void removeItem(String item) {
        if (item == null) {
            return;
        }
        item = item.trim();
        groceryList.remove(item);
        costs.remove(item);
        categories.remove(item);
        quantities.remove(item);
    }

    public void displayList() {
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        }
    }

    public boolean checkItem(String item) {
        return item != null && groceryList.contains(item.trim());
    }

    public double calculateTotalCost() {
        double total = 0;
        for (String item : groceryList) {
            total += costs.get(item) * quantities.get(item);
        }
        return total;
    }

    public void displayByCategory(String category) {
        boolean found = false;
        for (String item : groceryList) {
            if (category != null && categories.get(item).equalsIgnoreCase(category.trim())) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items in this category.");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }
        if (!checkItem(item)) {
            throw new IllegalArgumentException("Item not found in the grocery list.");
        }
        quantities.put(item.trim(), newQuantity);
    }

    public void displayAvailableItems() {
        boolean found = false;
        for (String item : groceryList) {
            int quantity = quantities.get(item);
            if (quantity > 0) {
                System.out.println(item + ": " + quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items with a positive quantity.");
        }
    }

    public static void main(String[] args) {
        GroceryListTester.demonstrateBasicList();
        System.out.println();
        GroceryListTester.demonstrateAllFeatures();
    }
}
