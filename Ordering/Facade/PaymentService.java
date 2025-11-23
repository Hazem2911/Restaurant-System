package Ordering.Facade;


public class PaymentService {
    public boolean processPayment(String productId, int quantity) {
        System.out.println("PaymentService: processing payment for " + productId + " qty=" + quantity);
        return true;
    }
}