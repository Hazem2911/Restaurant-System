package Payments;

public class PaymentResult {
    private final boolean success;
    private final String message;
    private final String transactionId;

    public PaymentResult(boolean success, String message, String transactionId) {
        this.success = success;
        this.message = message;
        this.transactionId = transactionId;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getTransactionId() { return transactionId; }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}