public class Bus extends Car {
    private int passengerCount;
    private int passengerCapacity;

    public Bus(String typeName, int passengerCapacity) {
        super(typeName);
        if (passengerCapacity < 0) {
            throw new IllegalArgumentException("Passenger capacity must be non-negative.");
        }
        this.passengerCapacity = passengerCapacity;
    }

    public boolean passengerEnter() {
        return passengerEnter(1);
    }

    public boolean passengerEnter(int count) {
        if (count <= 0 || count > passengerCapacity - passengerCount) {
            return false;
        }
        passengerCount += count;
        return true;
    }

    public boolean passengerExit() {
        return passengerExit(1);
    }

    public boolean passengerExit(int count) {
        if (count <= 0 || count > passengerCount) {
            return false;
        }
        passengerCount -= count;
        return true;
    }

    public int getPassengerCount() { return passengerCount; }
    public int getPassengerCapacity() { return passengerCapacity; }
}
