import java.util.List;

public interface ShippingStrategy {
    void ship(List<ShippingItem> items);
}