public interface PaymentStrategy {
    void checkout(Customer customer, Cart cart, ShippingStrategy shippingService);
}
