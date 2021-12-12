import java.text.DecimalFormat;

public class Customer {
    private final String name;
    private String password;
    private static double balance;
    public static String currency;


    public Customer(String name, String password, double balance, String currency) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return
                "Name: " + name +
                        ", Balance: " + balance +
                        ", Currency " + currency;
    }

    public void payForPurchase(double totalSum) {
        this.balance -= totalSum;
    }

    public boolean verifyPassword(String password) {
        if (password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}
