package Payments.Strategy;

import Payments.PaymentDetails;
import Payments.PaymentResult;

public interface IPaymentStrategy {
    PaymentResult process(double amount, PaymentDetails details);
}