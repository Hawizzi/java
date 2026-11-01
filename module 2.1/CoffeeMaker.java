public class CoffeeMaker {
    private boolean on;
    private String coffeeType = "normal";
    private int coffeeAmount = 10;

    public boolean isOn() {
        return on;
    }

    public void pressOnOff() {
        on = !on;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        if (on && ("normal".equals(coffeeType) || "espresso".equals(coffeeType))) {
            this.coffeeType = coffeeType;
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        if (on && coffeeAmount >= 10 && coffeeAmount <= 80) {
            this.coffeeAmount = coffeeAmount;
        }
    }
}
