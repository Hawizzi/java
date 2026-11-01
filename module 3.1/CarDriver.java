public class CarDriver {
    public static void main(String[] args) {
        demonstrateSportsCar();
        System.out.println();
        demonstrateBus();
    }

    public static void demonstrateSportsCar() {
        Car ordinary = new Car("Ordinary car", 50, 0);
        Car sports = new SportsCar("Sports car", 50, 0);
        Car[] cars = {ordinary, sports};
        for (Car car : cars) {
            car.fillTank();
            for (int i = 0; i < 3; i++) {
                car.accelerate();
            }
            System.out.println(car.getTypeName() + " after three accelerations: " + car.getSpeed() + " km/h");
            System.out.println("Fuel used: " + (car.getTankCapacity() - car.getGasolineLevel()) + " litres");
            double before = car.getSpeed();
            car.decelerate(10);
            System.out.println("Speed reduction: " + (before - car.getSpeed()) + " km/h");
        }
    }

    public static void demonstrateBus() {
        Bus bus = new Bus("City bus", 40);
        bus.fillTank();
        bus.passengerEnter(15);
        System.out.println("Passengers after boarding: " + bus.getPassengerCount());
        bus.passengerExit(5);
        System.out.println("Passengers after exiting: " + bus.getPassengerCount());
        System.out.println("Boarding beyond capacity accepted: " + bus.passengerEnter(31));
        bus.accelerate();
        System.out.println("Bus speed: " + bus.getSpeed() + " km/h");
    }
}
