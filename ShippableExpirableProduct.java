import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity,
                  LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
