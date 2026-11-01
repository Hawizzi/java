public class SportsCar extends Car {
    public SportsCar(String typeName) {
        super(typeName);
    }

    public SportsCar(String typeName, double tankCapacity, double speed) {
        super(typeName, tankCapacity, speed);
    }

    @Override
    public void accelerate() {
        turnOffCruiseControl();
        increaseSpeed(20);
    }

    @Override
    protected double getFuelConsumption() {
        return 0.02;
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount);
        super.decelerate(amount);
    }
}
