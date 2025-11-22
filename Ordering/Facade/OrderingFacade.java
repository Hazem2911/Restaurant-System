public class OrderingFacade implements IOrderingFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public OrderingFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
    }

    @Override
    public void placeOrder(String productId, int quantity) {
        if (inventoryService.isInStock(productId, quantity)) {
            boolean paymentSuccessful = paymentService.processPayment(productId, quantity);
            if (paymentSuccessful) {
                shippingService.shipProduct(productId, quantity);
                System.out.println("Order placed successfully for product: " + productId);
            } else {
                System.out.println("Payment failed for product: " + productId);
            }
        } else {
            System.out.println("Product: " + productId + " is out of stock.");
        }
    }
}