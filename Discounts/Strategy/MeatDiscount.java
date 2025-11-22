public class MeatDiscount implements IDiscountStrategy {
    private static final float DISCOUNT_RATE = 0.15f; // 15% discount

    @Override
    public float applyDiscount(float originalPrice) {
        return originalPrice * (1 - DISCOUNT_RATE);
    }
}