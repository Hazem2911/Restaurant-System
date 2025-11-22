public class PizzaDiscount implements IDiscountStrategy {
    private static final float DISCOUNT_RATE = 0.10f; // 10% discount

    @Override
    public float applyDiscount(float originalPrice) {
        return originalPrice * (1 - DISCOUNT_RATE);
    }
}