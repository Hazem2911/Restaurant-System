package Ordering.Facade;

public class OrderingFacade implements IOrderingFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderingFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
    }

    @Override
    public void placeOrder(String productId, int quantity) {
        if (!inventoryService.isInStock(productId, quantity)) {
            System.out.println("Product: " + productId + " is out of stock or insufficient quantity.");
            return;
        }

        boolean paymentSuccessful = paymentService.processPayment(productId, quantity);
        if (!paymentSuccessful) {
            System.out.println("Payment failed for product: " + productId);
            return;
        }

        // Reserve stock and complete order (no shipping step in restaurant context)
        inventoryService.reserve(productId, quantity);
        System.out.println("Order placed successfully for product: " + productId + " (qty=" + quantity + ")");
    }
}