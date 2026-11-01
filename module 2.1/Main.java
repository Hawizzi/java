import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Module 2.1");
            System.out.println("1. Television");
            System.out.println("2. Modified car constructor");
            System.out.println("3. Coffee maker");
            System.out.println("4. Cruise control");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");
            if (!scanner.hasNextLine()) {
                return;
            }
            switch (scanner.nextLine().trim()) {
                case "1":
                    TelevisionViewer.main(args);
                    break;
                case "2":
                    Car car = new Car("Toyota Corolla", 50, 20);
                    System.out.println("Car: " + car.getTypeName());
                    System.out.println("Tank capacity: " + car.getTankCapacity() + " litres");
                    System.out.println("Initial speed: " + car.getSpeed() + " km/h");
                    car.fillTank();
                    System.out.println("Gasoline level after filling: " + car.getGasolineLevel() + " litres");
                    break;
                case "3":
                    CoffeeMakerDriver.main(args);
                    break;
                case "4":
                    CarDriver.main(args);
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
