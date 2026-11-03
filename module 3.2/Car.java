public class Car extends AbstractVehicle {
    private String color;

    public Car() {
        this("Red", 0.07);
    }

    public Car(String color, double fuelEfficiency) {
        super("Car", "Petrol", fuelEfficiency, "L/km");
        this.color = color;
    }

    public String getColor() { return color; }

    @Override
    public String getInfo() {
        return getBasicInfo() + "\nColor: " + color;
    }
}
