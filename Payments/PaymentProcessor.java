package Payments;

import Payments.Strategy.IPaymentStrategy;
public class PaymentProcessor {
    private IPaymentStrategy strategy;

    public PaymentProcessor(IPaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IPaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentResult processPayment(double amount, PaymentDetails details) {
        if (strategy == null) {
            return new PaymentResult(false, "No payment strategy configured", null);
        }
        return strategy.process(amount, details);
    }
}