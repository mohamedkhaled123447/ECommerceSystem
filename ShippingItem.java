public class ShippingItem implements Shippable {
    private double weight;
    private String name;

    public ShippingItem(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
