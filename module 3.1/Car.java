public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;
    private double targetSpeed;
    private boolean cruiseControlOn;
    private static final double MIN_CRUISE_SPEED = 30;
    private static final double MAX_CRUISE_SPEED = 120;

    public Car(String typeName) {
        this(typeName, 100, 0);
    }

    public Car(double tankCapacity, double speed) {
        this("Car", tankCapacity, speed);
    }

    public Car(String typeName, double tankCapacity, double speed) {
        if (!Double.isFinite(tankCapacity) || tankCapacity <= 0
                || !Double.isFinite(speed) || speed < 0) {
            throw new IllegalArgumentException("Capacity must be positive and speed non-negative.");
        }
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.speed = speed;
    }

    public void accelerate() {
        turnOffCruiseControl();
        increaseSpeed(10);
    }

    protected void increaseSpeed(double amount) {
        double increase = Math.min(amount, gasolineLevel / getFuelConsumption());
        speed += increase;
        gasolineLevel = Math.max(0, gasolineLevel - increase * getFuelConsumption());
    }

    protected double getFuelConsumption() {
        return 0.01;
    }

    public void decelerate(int amount) {
        if (amount > 0) {
            turnOffCruiseControl();
            speed = Math.max(0, speed - amount);
        }
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = tankCapacity;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public boolean setTargetSpeed(double targetSpeed) {
        if (!Double.isFinite(targetSpeed) || targetSpeed < MIN_CRUISE_SPEED
                || targetSpeed > MAX_CRUISE_SPEED) {
            return false;
        }
        this.targetSpeed = targetSpeed;
        if (cruiseControlOn) {
            return turnOnCruiseControl();
        }
        return true;
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public boolean turnOnCruiseControl() {
        cruiseControlOn = false;
        if (targetSpeed < MIN_CRUISE_SPEED || targetSpeed > MAX_CRUISE_SPEED) {
            return false;
        }
        while (speed < targetSpeed) {
            double previousSpeed = speed;
            increaseSpeed(Math.min(10, targetSpeed - speed));
            if (speed == previousSpeed) {
                return false;
            }
        }
        while (speed > targetSpeed) {
            speed -= Math.min(10, speed - targetSpeed);
        }
        cruiseControlOn = true;
        return true;
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }
}

