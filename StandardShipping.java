import java.util.List;

public class StandardShipping implements ShippingStrategy {

    @Override
    public void ship(List<ShippingItem> items) {
        System.out.printf("package shipped");
    }
}