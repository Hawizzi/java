public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus() {
        this(40, 0.30);
    }

    public Bus(int capacity, double fuelEfficiency) {
        super("Bus", "Diesel", fuelEfficiency, "L/km");
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative.");
        }
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

    @Override
    public String getInfo() {
        return getBasicInfo() + "\nCapacity: " + capacity + " passengers";
    }
}
