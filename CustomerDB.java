import java.io.*;
import java.util.ArrayList;

public class CustomerDB {
    private static final String FILENAME = "customers.txt";
    private static final String DELIMITER = "\t";

    public static ArrayList<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(DELIMITER);

                if (columns.length == 3) {
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String email = columns[2];

                    Customer customer =
                            new Customer(firstName, lastName, email);

                    customers.add(customer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The customers.txt file was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            System.out.println(e);
        }

        return customers;
    }

    public static void saveAll(ArrayList<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILENAME)))) {

            for (Customer customer : customers) {
                writer.print(customer.getFirstName());
                writer.print(DELIMITER);
                writer.print(customer.getLastName());
                writer.print(DELIMITER);
                writer.println(customer.getEmail());
            }

        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            System.out.println(e);
        }
    }
}