package Payments.Strategy;

import Payments.PaymentDetails;
import Payments.PaymentResult;

public class CashPayment implements IPaymentStrategy {
    @Override
    public PaymentResult process(double amount, PaymentDetails details) {
        System.out.println("CashPayment: received cash amount " + amount);
        String txId = "CASH-" + System.currentTimeMillis();
        return new PaymentResult(true, "Cash received", txId);
    }
}