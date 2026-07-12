import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTesterApp {

    public static void main(String[] args) {
        method10();
    }

    public static void method10() {
        try {
            method20();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The requested file could not be found.");
        }
    }

    public static void method20() throws FileNotFoundException {
        method30();
    }

    public static void method30() throws FileNotFoundException {
        new FileInputStream("missing-file.txt");
    }
}