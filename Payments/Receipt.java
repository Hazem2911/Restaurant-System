package Payments;

public class Receipt {
    private String receiptId;
    private double amount;
    private String date;

    public Receipt(String receiptId, double amount, String date) {
        this.receiptId = receiptId;
        this.amount = amount;
        this.date = date;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId='" + receiptId + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}