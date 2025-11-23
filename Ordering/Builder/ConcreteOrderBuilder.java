package Ordering.Builder;

import Ordering.Order;
import Ordering.OrderItem;

import java.util.UUID;
public class ConcreteOrderBuilder implements IOrderBuilder {
    private Order order;

    public ConcreteOrderBuilder() {
        reset();
    }

    private void reset() {
        String id = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
        this.order = new Order(id);
    }

    @Override
    public void buildAppetizer() {
        order.addItem(new OrderItem("A-01", "Garlic Bread", 1, 3.50f));
    }

    @Override
    public void buildMainCourse() {
        order.addItem(new OrderItem("M-01", "Margherita Pizza", 1, 8.50f));
    }

    @Override
    public void buildDessert() {
        order.addItem(new OrderItem("D-01", "Vanilla Ice Cream", 1, 2.50f));
    }

    @Override
    public void buildBeverage() {
        order.addItem(new OrderItem("B-01", "Soft Drink", 1, 2.00f));
    }

    @Override
    public void setTableNumber(int tableNumber) {
        order.setTableNumber(tableNumber);
    }

    @Override
    public void setSpecialRequests(String requests) {
        order.setSpecialRequests(requests);
    }

    @Override
    public Order getOrder() {
        Order result = this.order;
        reset();
        return result;
    }
}