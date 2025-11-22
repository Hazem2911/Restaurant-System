public class DiscountService {
    public List<IDiscountStrategy> strategies;

    public DiscountService(List<IDiscountStrategy> strategies) {
        this.strategies = strategies;
    }
    void applyDiscount(Order order) {
    }
}