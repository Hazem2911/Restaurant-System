public class ConcreteOrderBuilder implements IOrderBuilder {
    private Order order;

    public ConcreteOrderBuilder() {
        this.order = new Order();
    }

    @Override
    public void buildMenu(IMenuFactory menuFactory) {
        IMenu menu = menuFactory.createMenu();
        order.setMenu(menu);
    }

    @Override
    public void buildTable(int tableNumber) {
        order.setTableNumber(tableNumber);
    }

    @Override
    public void buildSpecialRequests(String requests) {
        order.setSpecialRequests(requests);
    }

    @Override
    public Order getOrder() {
        return this.order;
    }
}