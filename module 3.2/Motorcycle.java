public class Motorcycle extends AbstractVehicle {
    private String color;

    public Motorcycle() {
        this("Black", 0.04);
    }

    public Motorcycle(String color, double fuelEfficiency) {
        super("Motorcycle", "Gasoline", fuelEfficiency, "L/km");
        this.color = color;
    }

    public String getColor() { return color; }

    @Override
    public String getInfo() {
        return getBasicInfo() + "\nColor: " + color;
    }
}
