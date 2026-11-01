public class CarDriver {
    public static void main(String[] args) {
        Car car = new Car("Toyota Corolla", 50, 20);
        System.out.println(car.getTypeName() + ": tank capacity is " + car.getTankCapacity() + " litres");
        System.out.println("Initial speed: " + car.getSpeed() + " km/h");
        car.fillTank();
        car.setTargetSpeed(80);
        System.out.println("Cruise control on: " + car.turnOnCruiseControl());
        System.out.println("Target speed: " + car.getTargetSpeed() + " km/h");
        System.out.println("Current speed: " + car.getSpeed() + " km/h");
        car.setTargetSpeed(50);
        System.out.println("Current speed after lowering target: " + car.getSpeed() + " km/h");
        car.turnOffCruiseControl();
        System.out.println("Cruise control on: " + car.isCruiseControlOn());
        System.out.println("Setting invalid target accepted: " + car.setTargetSpeed(150));

        Car emptyCar = new Car("Empty car", 50, 0);
        emptyCar.setTargetSpeed(80);
        if (!emptyCar.turnOnCruiseControl()) {
            System.out.println("Cruise control could not reach the target speed and is off.");
        }
    }
}
