public class ShapeCalculator {
    public static void main(String[] args) {
        displayShapes(true);
    }

    public static void displayShapes(boolean showColor) {
        Shape[] shapes = {
            new Circle(5, "Red"),
            new Rectangle(4, 6, "Blue"),
            new Triangle(3, 8, "Green")
        };
        System.out.println("Shape Calculator");
        System.out.println();
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape + ": " + shape.calculateArea()
                    + (showColor ? " (Color: " + shape.getColor() + ")" : ""));
        }
    }
}
