import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    private final DecimalFormat formatter = new DecimalFormat("0.00");


    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();


    public static void main(String[] args) {


        Main main = new Main();
        main.menu();
    }


    void menu() {
        String choice;

        do {
            String[] choices = {"Select...", "1", "2", "Quit"};

            choice = (String) JOptionPane.showInputDialog(null, "Welcome to the shop menu! Are you a sales representative or a customer?" +
                            "\n1: Sales representative" +
                            "\n2: Customer" +
                            "\n3: Choose QUIT to exit shop",
                    "Shop menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]);


            switch (choice) {
                case "1":
                    salesRep();
                    break;
                case "2":
                    customer();
                    break;
                case "Quit":
                    JOptionPane.showMessageDialog(null, "Exiting shop...");
                    break;
                default:
                    break;
            }

        } while (!choice.equals("Quit"));
        return;

    }


    void salesRep() {
        String choice;

        do {
            String[] choices = {"Select...", "1", "2", "3", "4", "Quit"};
            choice = (String) JOptionPane.showInputDialog(null, "Please choose an activity" +
                            "\n1: Add product" +
                            "\n2: View all products" +
                            "\n3: View sales history" +
                            "\n4: Register new customer" +
                            "\nChoose QUIT to exit menu",
                    "Sales representative menu",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    choices,
                    choices[0]);

            switch (choice) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Product added successfully: " + shop.addProduct());
                    break;
                case "2":
                    shop.viewAllProducts();
                    break;
                case "3":
                    shop.viewSoldProducts();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "New customer " + shop.addCustomer());
                    break;
                case "Quit":
                    JOptionPane.showMessageDialog(null, "Exiting menu...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter a valid choice!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("Quit"));

        return;
    }


    void customer() {

        Customer currentCustomer = customerLogin();
        if (currentCustomer != null) {
            String choice;
            do {
                String[] choices = {"Select...", "1", "2", "3", "4", "Quit"};
                choice = (String) JOptionPane.showInputDialog(null, "Please choose an activity" +

                                "\n1: Login" +
                                "\n2: View all products" +
                                "\n3: View balance" +
                                "\n4: Buy products" +
                                "\nChoose QUIT to exit menu",
                        "Welcome dear Customer!",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        choices,
                        choices[0]);

                switch (choice) {

                    case "1":
                        customerLogin();
                        break;
                    case "2":

                        shop.viewAllProducts();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, "Available balance is " + this.formatter.format(Customer.getBalance()) + " " + Customer.getCurrency());
                        break;
                    case "4":
                        //JOptionPane.showMessageDialog(null, shop.sellProducts());
                        buyProducts(currentCustomer);
                        break;
                    case "Quit":
                        JOptionPane.showMessageDialog(null, "Exiting menu...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Please enter a valid input!");
                        break;
                }
            } while (!choice.equalsIgnoreCase("Quit"));

        } else {
            System.out.println("Invalid Password!");
            customer();


        }

    }


    Customer customerLogin() {
        String name = JOptionPane.showInputDialog("Enter your name");
        String password = JOptionPane.showInputDialog("Enter password");
        Customer currentCustomer = shop.findByName(name);
        if (currentCustomer != null) {
            if (currentCustomer.verifyPassword(password)) {
                JOptionPane.showMessageDialog(null, "Login was successful");
                return currentCustomer;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password!");
            }

        }
        return null;
    }

    void buyProducts(Customer customer) {
        String productName = JOptionPane.showInputDialog("Choose a product to buy");
        Product product = shop.findProductByName(productName);
        double quantity = Double.parseDouble(JOptionPane.showInputDialog("Enter quantity"));
        shop.sellProduct(product, customer, quantity);
    }


}


