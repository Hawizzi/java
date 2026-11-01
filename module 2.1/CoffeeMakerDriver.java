public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is " + (coffeeMaker.isOn() ? "on" : "off"));
        coffeeMaker.setCoffeeType("espresso");
        coffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee type is " + coffeeMaker.getCoffeeType());
        System.out.println("Coffee amount is " + coffeeMaker.getCoffeeAmount() + " ml");
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is " + (coffeeMaker.isOn() ? "on" : "off"));
    }
}
