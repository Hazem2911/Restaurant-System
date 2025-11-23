package Ordering;

import Ordering.Observer.ISubject;
import Menu.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final List<OrderItem> items = new ArrayList<>();
    private float subtotal;
    private float tax;
    private float discount;
    private float total;

    // optional subject to publish order updates
    private final ISubject subject;

    // additional fields used by Builder / UML
    private Integer tableNumber;
    private String specialRequests;
    private IMenu menu;

    public Order(String id, ISubject subject) {
        this.id = id;
        this.subject = subject;
    }

    // convenience constructor used by builder (no subject)
    public Order(String id) {
        this(id, null);
    }

    public String getId() { return id; }
    public List<OrderItem> getItems() { return items; }

    public void addItem(OrderItem item) {
        if (item == null) return;
        items.add(item);
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void calculateTotals() {
        subtotal = 0f;
        for (OrderItem it : items) subtotal += it.getLinePrice();
        // simple tax example: 10% of subtotal
        tax = subtotal * 0.10f;
        total = subtotal + tax - discount;
        if (total < 0) total = 0f;
    }
     public void applyTaxRate(float taxRate) {
        // ensure subtotal is up to date
        subtotal = 0f;
        if (items != null) {
            for (OrderItem it : items) {
                subtotal += it.getLinePrice();
            }
        }

        tax = subtotal * taxRate;
        total = subtotal + tax - discount;
        if (total < 0) total = 0f;
    }

    /**
     * Place the order and notify observers via the subject (if provided).
     */
    public void place() {
        calculateTotals();
        if (subject != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Order ").append(id).append(" placed. Total: ").append(total);
            if (tableNumber != null) sb.append(" Table: ").append(tableNumber);
            if (specialRequests != null && !specialRequests.isEmpty())
                sb.append(" Requests: ").append(specialRequests);
            subject.setOrderUpdate(sb.toString());
        }
    }

    // getters for totals
    public float getSubtotal() { return subtotal; }
    public float getTax() { return tax; }
    public float getDiscount() { return discount; }
    public float getTotal() { return total; }

    // Builder-related setters/getters
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public Integer getTableNumber() { return tableNumber; }

    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    public String getSpecialRequests() { return specialRequests; }

    public void setMenu(IMenu menu) { this.menu = menu; }
    public IMenu getMenu() { return menu; }
}