package Ordering.Builder;

import Ordering.Order;

/**
 * Builder interface for constructing an Order in steps (matches UML).
 */
public interface IOrderBuilder {
    void buildAppetizer();
    void buildMainCourse();
    void buildDessert();
    void buildBeverage();

    void setTableNumber(int tableNumber);
    void setSpecialRequests(String requests);

    Order getOrder();
}