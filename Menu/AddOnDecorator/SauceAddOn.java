public class SauceAddOn extends AddOnDecorator {
    public SauceAddOn(IMenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String getAddOnName() {
        return menuItem.getName() + " + Sauce";
    }

    @Override
    public float getAddOnPrice() {
        return menuItem.getPrice() + 0.50f; // Assuming sauce costs an additional $0.50
    }
}