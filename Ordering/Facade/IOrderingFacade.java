package Ordering.Facade;

/**
 * Simple facade interface for placing an order (keeps same signature you provided).
 */
public interface IOrderingFacade {
    void placeOrder(String productId, int quantity);
}