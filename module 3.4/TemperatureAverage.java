import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class TemperatureAverage {
    public static void main(String[] args) {
        try {
            URLConnection connection = URI.create("https://users.metropolia.fi/~jarkkov/temploki.csv")
                    .toURL().openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), StandardCharsets.UTF_8))) {
                double average = calculateAverage(reader, "01.01.2023");
                System.out.printf(Locale.US, "Average UlkoTalo temperature on 1 January 2023: %.2f C%n", average);
            }
        } catch (IOException exception) {
            System.out.println("Could not calculate the temperature average: " + exception.getMessage());
        }
    }

    public static double calculateAverage(BufferedReader reader, String date) throws IOException {
        String header = reader.readLine();
        if (header == null) {
            throw new IOException("The CSV file is empty.");
        }
        String[] columns = header.replace("\uFEFF", "").split(";", -1);
        int timeIndex = -1;
        int temperatureIndex = -1;
        for (int i = 0; i < columns.length; i++) {
            if (columns[i].trim().equals("Aika")) { timeIndex = i; }
            if (columns[i].trim().equals("UlkoTalo")) { temperatureIndex = i; }
        }
        if (timeIndex < 0 || temperatureIndex < 0) {
            throw new IOException("Required Aika or UlkoTalo column is missing.");
        }
        double total = 0;
        int count = 0;
        int lineNumber = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.trim().isEmpty()) { continue; }
            String[] values = line.split(";", -1);
            if (values.length <= timeIndex) {
                throw new IOException("Missing timestamp on line " + lineNumber);
            }
            String timestamp = values[timeIndex].trim();
            if (!timestamp.startsWith(date + " ")) { continue; }
            if (values.length <= temperatureIndex) {
                throw new IOException("Missing temperature on line " + lineNumber);
            }
            try {
                double temperature = Double.parseDouble(values[temperatureIndex].trim().replace(',', '.'));
                if (!Double.isFinite(temperature)) { throw new NumberFormatException(); }
                total += temperature;
                count++;
            } catch (NumberFormatException exception) {
                throw new IOException("Invalid temperature on line " + lineNumber, exception);
            }
        }
        if (count == 0) {
            throw new IOException("No measurements found for " + date);
        }
        return total / count;
    }
}
