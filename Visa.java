import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Visa implements PaymentStrategy {

    private static final double SHIPPING_RATE = 0.5; // $0.5 per kg

    @Override
    public void checkout(Customer customer, Cart cart, ShippingStrategy shippingService) {

        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        List<ShippingItem> shippingItems = new ArrayList<>();
        List<CartItem> filteredItems = new ArrayList<>();
        double subtotal = 0;
        double shippingFees = 0;


        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();


            if (product.getQuantity() < quantity) {
                System.out.println("Out of stock: " + product.getName());
                continue;
            }


            if (product instanceof Expirable) {
                if (((Expirable) product).getExpiryDate().isBefore(LocalDate.now())) {
                    System.out.println("Expired product: " + product.getName());
                    continue;
                }
            }


            subtotal += product.getPrice() * quantity;


            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                shippingFees += shippable.getWeight() * SHIPPING_RATE * quantity;
                shippingItems.add(new ShippingItem(shippable.getWeight(),shippable.getName()));
            }
            filteredItems.add(item);
        }


        double total = subtotal + shippingFees;


        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance");
            return;
        }

        customer.setBalance(customer.getBalance() - total);
        double totalWeight = 0;

        System.out.println("\n** Shipment notice **");
        for (CartItem item : filteredItems) {
            if (item.getProduct() instanceof Shippable) {
                Shippable shippable = (Shippable) item.getProduct();
                System.out.printf("%dx %s          %.2f kg\n", item.getQuantity(),
                        item.getProduct().getName(), shippable.getWeight() * item.getQuantity());
                totalWeight += shippable.getWeight() * item.getQuantity();
            }
        }
        System.out.printf("Total package weight %.2f kg\n",totalWeight);
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : filteredItems) {
            System.out.printf("%dx %s          %.2f\n", item.getQuantity(),
                    item.getProduct().getName(), item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal          $%.2f%n", subtotal);
        System.out.printf("Shipping          $%.2f%n", shippingFees);
        System.out.printf("Amount            $%.2f%n", total);
        shippingService.ship(shippingItems);
    }
}
