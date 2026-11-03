public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private String type;
    private String fuel;
    private boolean running;
    private double fuelEfficiency;
    private String efficiencyUnit;

    public AbstractVehicle(String type, String fuel, double fuelEfficiency, String efficiencyUnit) {
        if (!Double.isFinite(fuelEfficiency) || fuelEfficiency < 0) {
            throw new IllegalArgumentException("Fuel efficiency must be finite and non-negative.");
        }
        this.type = type;
        this.fuel = fuel;
        this.fuelEfficiency = fuelEfficiency;
        this.efficiencyUnit = efficiencyUnit;
    }

    @Override
    public void start() {
        running = true;
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println(type + " is stopping...");
    }

    public boolean isRunning() { return running; }
    public String getType() { return type; }
    public String getFuel() { return fuel; }
    public String getEfficiencyUnit() { return efficiencyUnit; }

    protected String getBasicInfo() {
        return type + " Information:\nType: " + type + "\nFuel: " + fuel;
    }

    @Override
    public abstract String getInfo();

    @Override
    public void charge() {
        System.out.println(type + ": Not possible to charge.");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
