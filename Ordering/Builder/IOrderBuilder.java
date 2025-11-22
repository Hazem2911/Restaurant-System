public interface IOrderBuilder {
    void buildStarter();
    void buildMainCourse();
    void buildDessert();
    void buildBeverage();
    Order getOrder();
}