import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FibonacciCsv {
    public static void main(String[] args) {
        Path file = Paths.get("fibonacci.csv");
        try {
            writeSequence(file);
            System.out.println("Saved 60 Fibonacci numbers to " + file.toAbsolutePath());
        } catch (IOException exception) {
            System.out.println("Could not write the CSV file: " + exception.getMessage());
        }
    }

    public static void writeSequence(Path file) throws IOException {
        long current = 0;
        long next = 1;
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write("Fibonacci");
            writer.newLine();
            for (int i = 0; i < 60; i++) {
                writer.write(Long.toString(current));
                writer.newLine();
                long sum = current + next;
                current = next;
                next = sum;
            }
        }
    }
}
