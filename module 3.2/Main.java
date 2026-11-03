import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 3.2");
            System.out.println("1. Vehicle interfaces");
            System.out.println("2. Abstract vehicle hierarchy");
            System.out.println("3. Electric vehicles");
            System.out.println("4. Fuel efficiency");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                return;
            }
            try {
                int task = Integer.parseInt(choice);
                if (task >= 1 && task <= 4) {
                    VehicleDemo.runTask(task);
                } else {
                    System.out.println("Please choose a number from 0 to 4.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please choose a number from 0 to 4.");
            }
            System.out.println();
        }
    }
}
