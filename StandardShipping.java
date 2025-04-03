import java.util.List;

public class StandardShipping implements ShippingStrategy {

    @Override
    public void ship(List<CartItem> items) {
        double totalWeight = 0;
        System.out.println("\n** Shipment notice **");
        for (CartItem item : items) {
            Shippable shippable = (Shippable) item.getProduct();
            totalWeight += shippable.getWeight();
            System.out.printf("%dx %s          %.2f kg\n", item.getQuantity(),
                    item.getProduct().getName(), shippable.getWeight());
        }
        System.out.printf("Total package weight %.2f kg\n",totalWeight);
    }
}