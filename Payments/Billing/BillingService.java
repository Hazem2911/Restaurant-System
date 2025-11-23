package Payments.Billing;
import Payments.Receipt;
import Ordering.Order;

public class BillingService {
    private static final float TAX_RATE = 0.10f; 

    public BillingService() { }
    public Receipt generateReceipt(String receiptId, double amount, String date) {
        return new Receipt(receiptId, amount, date);
    }

    public Receipt generateReceipt(Order order, String date) {
        if (order == null) return null;
        order.calculateTotals(); 
        return new Receipt(order.getId(), order.getTotal(), date);
    }
    public void applyTax(Order order) {
        if (order == null) return;
        order.applyTaxRate(TAX_RATE);
    }

}