public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this(radius, "Unspecified");
    }

    public Circle(double radius, String color) {
        super(color);
        validateDimension(radius);
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
}
