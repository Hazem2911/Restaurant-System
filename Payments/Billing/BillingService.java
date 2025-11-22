public class BillingService {

    public Receipt generateReceipt(String receiptId, double amount, String date) {
        return new Receipt(receiptId, amount, date);
    }
}