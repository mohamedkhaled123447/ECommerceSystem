public class Customer {
    private Cart cart;
    private PaymentStrategy paymentStrategy;
    private ShippingStrategy shippingStrategy;
    private double balance;

    public Customer(Cart cart, PaymentStrategy paymentStrategy, ShippingStrategy shippingStrategy, double balance) {
        this.cart = cart;
        this.paymentStrategy = paymentStrategy;
        this.shippingStrategy = shippingStrategy;
        this.balance = balance;
    }

    public void checkout() {
        paymentStrategy.checkout(this,cart,shippingStrategy);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
