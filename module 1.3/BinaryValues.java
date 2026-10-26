import java.math.BigInteger;
import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        while (true) {
            System.out.println("Enter a binary number (0s and 1s only):");
            String binary = scanner.nextLine().trim();
            BigInteger decimal = BigInteger.ZERO;
            boolean valid = !binary.isEmpty();

            for (int i = 0; i < binary.length(); i++) {
                char bit = binary.charAt(i);
                if (bit != '0' && bit != '1') {
                    valid = false;
                    break;
                }
                decimal = decimal.multiply(BigInteger.valueOf(2))
                        .add(BigInteger.valueOf(bit - '0'));
            }

            if (valid) {
                System.out.println("Decimal equivalent: " + decimal);
                break;
            }
            System.out.println("Invalid binary number. Please try again.");
        }
    }
}

