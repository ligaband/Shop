public class Product {

    private String name;
    private double price;
    private double quantity;
    private final String measurement;

    public Product(String name, double price, double quantity, String measurement) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                        ", price: " + price +
                        ", quantity: " + quantity +
                        ", measurement: " + measurement;
    }

    public void productSold(double quantity) {
        this.quantity -= quantity;
    }


}
