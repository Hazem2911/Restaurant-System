package Discounts;

import Discounts.Strategy.IDiscountStrategy;
import Discounts.Strategy.PizzaDiscount;
import Discounts.Strategy.MeatDiscount;
import Discounts.Strategy.ChickenDiscount;

public class DiscountService {

    public IDiscountStrategy getStrategy(String itemType) {
        if (itemType == null) return null;
        switch (itemType.trim().toLowerCase()) {
            case "pizza":
                return new PizzaDiscount();
            case "meat":
            case "steak":
                return new MeatDiscount();
            case "chicken":
                return new ChickenDiscount();
            default:
                return null;
        }
    }

    public float applyDiscount(String itemType, float originalPrice) {
        IDiscountStrategy strat = getStrategy(itemType);
        return (strat == null) ? originalPrice : strat.applyDiscount(originalPrice);
    }

    // convenience overload: apply a given strategy directly
    public float applyDiscount(IDiscountStrategy strategy, float originalPrice) {
        return (strategy == null) ? originalPrice : strategy.applyDiscount(originalPrice);
    }
}