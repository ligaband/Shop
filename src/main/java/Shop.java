import javax.swing.*;
import java.util.ArrayList;

public class Shop {

    public ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Product> soldProducts = new ArrayList<>();

    public String addProduct() {
        String name = JOptionPane.showInputDialog("Product name");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Product price"));
        double quantity = Double.parseDouble(JOptionPane.showInputDialog("Product quantity"));
        String[] availableMeasurements = {"kg", "litre", "item"};
        String measurement = (String) JOptionPane.showInputDialog(

                null,
                "choose product measurement",
                "Product measurement",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableMeasurements,
                availableMeasurements[0]
        );
        Product product = new Product(name, price, quantity, measurement);
        this.products.add(product);
        System.out.println(this.products);
        return product.getQuantity() + " " + product.getMeasurement() + " " + product.getName() + ", price per " + product.getMeasurement() + " is " + product.getPrice() + " EUR";

    }

    public String addCustomer() {
        String name = JOptionPane.showInputDialog("Customer name?");
        String password = JOptionPane.showInputDialog("Password.");
        double balance = Double.parseDouble(JOptionPane.showInputDialog("Please set balance."));
        String[] availableCurrencies = {"EUR", "USD"};
        String currency = (String) JOptionPane.showInputDialog(
                null,
                "Choose a currency for your balance",
                "Currency",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableCurrencies,
                availableCurrencies[0]
        );

        Customer customer = new Customer(name, password, balance, currency);
        this.customers.add(customer);
        System.out.println(this.customers);
        return customer.getName() + " " + " registered successfully";
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ArrayList<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Customer findByName(String customerName) {
        for (Customer customer : customers) {
            if (customerName.equalsIgnoreCase(customer.getName())) {
                return customer;
            }
        }
        return null;
    }

    //    public void viewAllProducts() {
//        System.out.println("Product list");
//        for (Product product : products) {
//
//            System.out.println("Name: " + product.getName() + " Price: " + product.getPrice() + " EUR " + " Quantity: " + product.getQuantity() + " Measurement: " + product.getMeasurement());
//
//        }
//    }
//
    public String viewAllProducts() {
        Product allProducts = (Product) JOptionPane.showInputDialog(
                null,
                "Product list",
                "Available Products",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.products.toArray(),
                this.products.toArray()[0]);


        return "Return to menu";

    }

    public void sellProduct(Product product, Customer customer, double quantity) {
        if (product.getQuantity() != 0) {
            if (quantity <= product.getQuantity()) {
                double totalSum = quantity * product.getPrice();

                if (customer.getBalance() >= totalSum) {
                    customer.payForPurchase(totalSum);

                    product.productSold(quantity);

                    Product soldProduct = new Product(product.getName(), product.getPrice(), quantity, product.getMeasurement());
                    this.soldProducts.add(soldProduct);
                    JOptionPane.showMessageDialog(null, "You just bought " + soldProduct.getQuantity() + " " + soldProduct.getMeasurement() + " of " + soldProduct.getName() + ". Thank You!");

                } else {
                    System.out.println("Not enough funds, please check your balance!");
                }

            } else {
                System.out.println("Your desired amount is not available, please try again. Available amount is: " + product.getQuantity());
            }
        } else {
            System.out.println("Product is sold out!");
        }
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (name.equalsIgnoreCase(product.getName())) {
                return product;

            }

        }
        return null;
    }


    public String viewSoldProducts() {
        Product soldProduct = (Product) JOptionPane.showInputDialog(
                null,
                "Sold product list",
                "Sold products",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.soldProducts.toArray(),
                this.soldProducts.toArray()[0]);

        return "Sold products: " + soldProduct.getName() + soldProduct.getPrice() + soldProduct.getQuantity() + soldProduct.getMeasurement();

    }


}
