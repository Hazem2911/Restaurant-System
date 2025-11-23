package Payments.Strategy;

import Payments.PaymentDetails;
import Payments.PaymentResult;

public class CreditCardPayment implements IPaymentStrategy {
    @Override
    public PaymentResult process(double amount, PaymentDetails details) {
        if (details == null || details.getCardNumber() == null) {
            return new PaymentResult(false, "Missing card details", null);
        }
        // Basic mock validation
        String card = details.getCardNumber();
        if (card.length() < 12) {
            return new PaymentResult(false, "Invalid card number", null);
        }
        String txId = "CARD-" + System.currentTimeMillis();
        System.out.println("CreditCardPayment: charged " + amount + " to card " + mask(card));
        return new PaymentResult(true, "Card charged", txId);
    }

    private String mask(String card) {
        if (card == null) return null;
        if (card.length() <= 4) return card;
        return "**** **** **** " + card.substring(card.length() - 4);
    }
}