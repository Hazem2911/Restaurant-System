public class AddOnDecorator implements IMenuItem , IAddOn {
    private IMenuItem menuItem;
    private string addOnName;
    private float addOnPrice;

    public AddOnDecorator(IMenuItem menuItem, string addOnName, float addOnPrice) {
        this.menuItem = menuItem;
        this.addOnName = addOnName;
        this.addOnPrice = addOnPrice;
    }

    public string getName() {
        return menuItem.getName() + " with " + addOnName;
    }

    public float getPrice() {
        return menuItem.getPrice() + addOnPrice;
    }

    public string getCategory() {
        return menuItem.getCategory();
    }

    public int getID() {
        return menuItem.getID();
    }
}