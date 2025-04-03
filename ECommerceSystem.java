import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ECommerceSystem {
    public static void main(String[] args) {

        Product cheese = new ShippableExpirableProduct("cheese", 8.99, 10,
                LocalDate.of(2000,12,22), 0.2);
        Product tv = new ShippableProduct("Smart TV", 799.99, 5, 12.5);
        Product card = new NormalProduct("card", 10.0, 100);


        Cart cart = new Cart();
        PaymentStrategy visa = new Visa();
        ShippingStrategy shippingService = new StandardShipping();
        Customer customer = new Customer(cart, visa, shippingService, 1500);


        customer.getCart().addItem(cheese, 10);
        customer.getCart().addItem(tv, 1);
        customer.getCart().addItem(card, 3);
        customer.checkout();


    }

}
