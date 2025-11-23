package Payments.Strategy;

import Payments.PaymentDetails;
import Payments.PaymentResult;


public class MobileWalletPayment implements IPaymentStrategy {
    @Override
    public PaymentResult process(double amount, PaymentDetails details) {
        if (details == null || details.getMobileNumber() == null) {
            return new PaymentResult(false, "Missing mobile wallet details", null);
        }
        String txId = "WALLET-" + System.currentTimeMillis();
        System.out.println("MobileWalletPayment: charged " + amount + " to mobile " + details.getMobileNumber());
        return new PaymentResult(true, "Mobile wallet charged", txId);
    }
}