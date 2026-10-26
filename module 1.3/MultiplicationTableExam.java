import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        int score;

        do {
            score = 0;
            System.out.println("Starting a new set of ten multiplication problems.");
            for (int question = 1; question <= 10; question++) {
                int first = (int) (Math.random() * 10) + 1;
                int second = (int) (Math.random() * 10) + 1;
                int answer;

                while (true) {
                    System.out.println("Question " + question + ": " + first + " * " + second + " = ?");
                    try {
                        answer = Integer.parseInt(scanner.nextLine().trim());
                        break;
                    } catch (NumberFormatException exception) {
                        System.out.println("Please enter a whole number.");
                    }
                }

                if (answer == first * second) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + (first * second) + ".");
                }
            }
            System.out.println("Your score: " + score + "/10");
            if (score < 10) {
                System.out.println("Let's practice again!");
            }
        } while (score < 10);

        System.out.println("Congratulations! You have mastered the multiplication tables!");
    }
}

