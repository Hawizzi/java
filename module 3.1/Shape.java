public class Shape {
    private String color;

    public Shape() {
        this("Unspecified");
    }

    public Shape(String color) {
        setColor(color);
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color must not be empty.");
        }
        this.color = color.trim();
    }

    public double calculateArea() {
        return 0;
    }

    protected static void validateDimension(double dimension) {
        if (!Double.isFinite(dimension) || dimension < 0) {
            throw new IllegalArgumentException("Dimensions must be finite and non-negative.");
        }
    }
}
