import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Module 1.3");
            System.out.println("1. Quadratic equation solver");
            System.out.println("2. Binary values");
            System.out.println("3. Prime number generator");
            System.out.println("4. Multiplication table exam");
            System.out.println("0. Exit");
            System.out.println("Choose a task:");

            if (!scanner.hasNextLine()) {
                return;
            }

            switch (scanner.nextLine().trim()) {
                case "1":
                    QuadraticEquationSolver.run(scanner);
                    break;
                case "2":
                    BinaryValues.run(scanner);
                    break;
                case "3":
                    PrimeNumberGenerator.run(scanner);
                    break;
                case "4":
                    MultiplicationTableExam.run(scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose a number from 0 to 4.");
                    break;
            }
            System.out.println();
        }
    }
}
