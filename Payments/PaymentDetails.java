package Payments;
public class PaymentDetails {
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String mobileNumber;
    private String pin;

    public PaymentDetails() {}
    public static PaymentDetails forCard(String holder, String number, String cvv, String expiry) {
        PaymentDetails d = new PaymentDetails();
        d.cardHolderName = holder;
        d.cardNumber = number;
        d.cvv = cvv;
        d.expiryDate = expiry;
        return d;
    }
    public static PaymentDetails forMobile(String mobileNumber, String pin) {
        PaymentDetails d = new PaymentDetails();
        d.mobileNumber = mobileNumber;
        d.pin = pin;
        return d;
    }
    public static PaymentDetails forCash() {
        return new PaymentDetails();
    }

    // Getters
    public String getCardHolderName() { return cardHolderName; }
    public String getCardNumber() { return cardNumber; }
    public String getCvv() { return cvv; }
    public String getExpiryDate() { return expiryDate; }
    public String getMobileNumber() { return mobileNumber; }
    public String getPin() { return pin; }
}