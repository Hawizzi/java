import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        double a = 0;
        double b = 0;
        double c = 0;

        while (true) {
            System.out.println("Enter a, b and c, separated by spaces:");
            String[] coefficients = scanner.nextLine().trim().split("\\s+");
            try {
                if (coefficients.length != 3) {
                    throw new NumberFormatException();
                }
                a = Double.parseDouble(coefficients[0]);
                b = Double.parseDouble(coefficients[1]);
                c = Double.parseDouble(coefficients[2]);
                if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(c)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Please enter three finite numbers.");
            }
        }

        if (a == 0) {
            if (b != 0) {
                System.out.println("Linear equation root: " + (-c / b));
            } else if (c == 0) {
                System.out.println("Infinitely many solutions");
            } else {
                System.out.println("No real roots");
            }
        } else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                System.out.println("No real roots");
            } else if (discriminant == 0) {
                System.out.println("Root: " + (-b / (2 * a)));
            } else {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Root 1: " + root1);
                System.out.println("Root 2: " + root2);
            }
        }
    }
}

