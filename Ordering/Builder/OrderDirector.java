package Ordering.Builder;

/**
 * Director that knows the sequence to build an Order (uses IOrderBuilder).
 */
public class OrderDirector {
    private final IOrderBuilder orderBuilder;

    public OrderDirector(IOrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public Ordering.Order constructFullMeal(int tableNumber, String specialRequests) {
        orderBuilder.setTableNumber(tableNumber);
        orderBuilder.setSpecialRequests(specialRequests);

        orderBuilder.buildAppetizer();
        orderBuilder.buildMainCourse();
        orderBuilder.buildDessert();
        orderBuilder.buildBeverage();

        return orderBuilder.getOrder();
    }
}