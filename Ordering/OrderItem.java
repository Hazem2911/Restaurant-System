package Ordering;

/**
 * OrderItem used by Order. Keeps id/name, quantity and unit price and exposes line price.
 */
public class OrderItem {
    private final String menuItemId;
    private final String name;
    private final int quantity;
    private final float unitPrice;

    public OrderItem(String menuItemId, String name, int quantity, float unitPrice) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.quantity = Math.max(1, quantity);
        this.unitPrice = unitPrice;
    }

    public String getMenuItemId() { return menuItemId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public float getUnitPrice() { return unitPrice; }
    public float getLinePrice() { return unitPrice * quantity; }
}