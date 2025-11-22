public class OrderDirector {
    private OrderBuilder orderBuilder;

    public OrderDirector(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public Order constructOrder() {
        orderBuilder.buildAppetizer();
        orderBuilder.buildMainCourse();
        orderBuilder.buildDessert();
        orderBuilder.buildBeverage();
        return orderBuilder.getOrder();
    }
}