import java.util.List;

public interface ShippingStrategy {
    void ship(List<CartItem> items);
}