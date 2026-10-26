import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        String[] firstNames = {"Aino", "Olli", "Emma", "Elias", "Sofia", "Leo", "Ella", "Eero"};
        String[] lastNames = {"Virtanen", "Korhonen", "Nieminen", "Makinen", "Laine", "Heikkinen"};
        int count;

        while (true) {
            System.out.println("How many random names should be generated?");
            try {
                count = Integer.parseInt(scanner.nextLine().trim());
                if (count >= 0) {
                    break;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Please enter a non-negative integer.");
        }

        for (int i = 0; i < count; i++) {
            int firstIndex = (int) (Math.random() * firstNames.length);
            int lastIndex = (int) (Math.random() * lastNames.length);
            System.out.println(firstNames[firstIndex] + " " + lastNames[lastIndex]);
        }
    }
}
