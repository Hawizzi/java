import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class EnrollmentDemo {
    public static void main(String[] args) {
        Student student = new Student(1, "Alice", 21);
        Course course = new Course("JAVA101", "Object-Oriented Programming", "John Smith");
        Enrollment enrollment = new Enrollment(student, course, LocalDate.now().toString());

        try {
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
                output.writeObject(enrollment);
            }
            System.out.println("Enrollment saved to enrollments.ser");
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
                Enrollment restored = (Enrollment) input.readObject();
                System.out.println("Deserialized enrollment:");
                System.out.println(restored);
            }
        } catch (IOException | ClassNotFoundException | ClassCastException exception) {
            System.out.println("Could not save or load enrollment: " + exception.getMessage());
        }
    }
}
