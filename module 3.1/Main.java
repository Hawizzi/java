import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 3.1");
            System.out.println("1. Sports car");
            System.out.println("2. Bus");
            System.out.println("3. Shape hierarchy and polymorphism");
            System.out.println("4. Shape colors");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            switch (scanner.nextLine().trim()) {
                case "1":
                    CarDriver.demonstrateSportsCar();
                    break;
                case "2":
                    CarDriver.demonstrateBus();
                    break;
                case "3":
                    ShapeCalculator.displayShapes(false);
                    break;
                case "4":
                    ShapeCalculator.displayShapes(true);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose a number from 0 to 4.");
                    break;
            }
            System.out.println();
        }
    }
}
