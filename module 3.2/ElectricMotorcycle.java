public class ElectricMotorcycle extends AbstractVehicle {
    private String color;
    private int batteryLevel;

    public ElectricMotorcycle() {
        this("Green", 0.06);
    }

    public ElectricMotorcycle(String color, double fuelEfficiency) {
        super("Electric Motorcycle", "Electricity", fuelEfficiency, "kWh/km");
        this.color = color;
    }

    public String getColor() { return color; }
    public int getBatteryLevel() { return batteryLevel; }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println("Electric Motorcycle is charging... Battery: " + batteryLevel + "%");
    }

    @Override
    public String getInfo() {
        return getBasicInfo() + "\nColor: " + color + "\nBattery: " + batteryLevel + "%";
    }
}
