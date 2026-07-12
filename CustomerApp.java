import java.util.ArrayList;
import java.util.Scanner;

public class CustomerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = CustomerDB.getAll();

        while (true) {
            System.out.println("\nCustomer Manager");
            System.out.println("list - List customers");
            System.out.println("add - Add customer");
            System.out.println("exit - Exit");
            System.out.print("Command: ");

            String command = sc.nextLine().trim().toLowerCase();

            if (command.equals("list")) {
                for (Customer c : customers) {
                    System.out.println(c);
                }
            } else if (command.equals("add")) {
                System.out.print("First name: ");
                String first = sc.nextLine();

                System.out.print("Last name: ");
                String last = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                customers.add(new Customer(first, last, email));
                CustomerDB.saveAll(customers);

                System.out.println("Customer added.");
            } else if (command.equals("exit")) {
                CustomerDB.saveAll(customers);
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}