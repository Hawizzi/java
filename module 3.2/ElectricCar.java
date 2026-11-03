public class ElectricCar extends AbstractVehicle {
    private String color;
    private int batteryLevel;

    public ElectricCar() {
        this("Blue", 0.16);
    }

    public ElectricCar(String color, double fuelEfficiency) {
        super("Electric Car", "Electricity", fuelEfficiency, "kWh/km");
        this.color = color;
    }

    public String getColor() { return color; }
    public int getBatteryLevel() { return batteryLevel; }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println("Electric Car is charging... Battery: " + batteryLevel + "%");
    }

    @Override
    public String getInfo() {
        return getBasicInfo() + "\nColor: " + color + "\nBattery: " + batteryLevel + "%";
    }
}
