public class VehicleDemo {
    public static void main(String[] args) {
        for (int task = 1; task <= 4; task++) {
            runTask(task);
            System.out.println();
        }
    }

    public static void runTask(int task) {
        switch (task) {
            case 1:
                System.out.println("Vehicle Demonstration");
                System.out.println();
                Vehicle[] vehicles = {new Car(), new Motorcycle(), new Bus()};
                for (Vehicle vehicle : vehicles) {
                    vehicle.start();
                    vehicle.stop();
                    System.out.println(vehicle.getInfo());
                    System.out.println();
                }
                break;
            case 2:
                AbstractVehicle[] hierarchy = {new Car(), new Motorcycle(), new Bus()};
                for (AbstractVehicle vehicle : hierarchy) {
                    System.out.println(vehicle.getInfo());
                    vehicle.start();
                    System.out.println("Running: " + vehicle.isRunning());
                    vehicle.stop();
                    System.out.println("Running: " + vehicle.isRunning());
                    System.out.println();
                }
                break;
            case 3:
                ElectricVehicle[] chargeable = {
                    new Car(), new Motorcycle(), new Bus(), new ElectricCar(), new ElectricMotorcycle()
                };
                for (ElectricVehicle vehicle : chargeable) {
                    vehicle.charge();
                }
                Vehicle[] electricVehicles = {new ElectricCar(), new ElectricMotorcycle()};
                for (Vehicle vehicle : electricVehicles) {
                    ((ElectricVehicle) vehicle).charge();
                    vehicle.start();
                    vehicle.stop();
                    System.out.println(vehicle.getInfo());
                    System.out.println();
                }
                break;
            case 4:
                AbstractVehicle[] efficientVehicles = {
                    new Car(), new Motorcycle(), new Bus(), new ElectricCar(), new ElectricMotorcycle()
                };
                for (AbstractVehicle vehicle : efficientVehicles) {
                    Vehicle contract = vehicle;
                    System.out.println(vehicle.getType() + " efficiency: "
                            + contract.calculateFuelEfficiency() + " " + vehicle.getEfficiencyUnit());
                }
                break;
            default:
                throw new IllegalArgumentException("Task must be between 1 and 4.");
        }
    }
}
