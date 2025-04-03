import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Not enough stock for: " + product.getName());
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

}
