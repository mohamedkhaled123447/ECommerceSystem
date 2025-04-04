import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ECommerceSystem {
    public static void main(String[] args) {

        Product cheese = new ShippableExpirableProduct("cheese", 8.99, 10,
                LocalDate.now().plusDays(14), 0.2);
        Product tv = new ShippableProduct("Smart TV", 799.99, 5, 12.5);
        Product card = new NormalProduct("card", 10.0, 100);


        Cart cart = new Cart();
        PaymentStrategy visa = new Visa();
        ShippingStrategy shippingService = new StandardShipping();
        Customer customer = new Customer(cart, visa, shippingService, 1500);

       //normal case
        customer.getCart().addItem(cheese, 10);
        customer.getCart().addItem(tv, 1);
        customer.getCart().addItem(card, 3);
        customer.checkout();
        System.out.println("\n*******************************************\n");
        //handle date expire
       /* Product cheese1 =new ShippableExpirableProduct("cheese1", 8.99, 10,
                LocalDate.of(2024,2,2), 0.2);
        customer.getCart().addItem(cheese1,2);
        customer.checkout();
        System.out.println("\n*******************************************\n");*/
        // handle Out of stock
       /* Product phone = new ShippableProduct("Smart phone", 799.99, 5, 12.5);
        customer.getCart().addItem(phone,10);
        customer.checkout();*/
    }

}
