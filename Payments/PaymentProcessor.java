public class PaymentProcessor {
    public IPaymentStrategy paymentStrategy;
    public PaymentProcessor(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}