public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this(base, height, "Unspecified");
    }

    public Triangle(double base, double height, String color) {
        super(color);
        validateDimension(base);
        validateDimension(height);
        this.base = base;
        this.height = height;
    }

    public double getBase() { return base; }
    public double getHeight() { return height; }

    @Override
    public double calculateArea() {
        return base * height / 2;
    }

    @Override
    public String toString() {
        return "Triangle with base " + base + " and height " + height;
    }
}
