package Ordering.Facade;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


public class InventoryService {
    private final Map<String, Integer> stock = new ConcurrentHashMap<>();

    public InventoryService() {
        stock.put("P-01", 10);
        stock.put("P-02", 5);
        stock.put("K-01", 20);
    }

    public boolean isInStock(String productId, int requiredQty) {
        if (productId == null || requiredQty <= 0) return false;
        return stock.getOrDefault(productId, 0) >= requiredQty;
    }

    public void reserve(String productId, int qty) {
        stock.computeIfPresent(productId, (k, v) -> Math.max(0, v - qty));
    }

    public void addStock(String productId, int qty) {
        stock.merge(productId, qty, Integer::sum);
    }
}