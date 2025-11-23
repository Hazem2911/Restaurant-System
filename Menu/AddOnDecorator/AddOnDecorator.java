package Menu.AddOnDecorator;

import Menu.IMenuItem;
public abstract class AddOnDecorator implements IMenuItem, IAddOn {
    protected final IMenuItem menuItem;
    protected final String addOnName;
    protected final float addOnPrice;
    public AddOnDecorator(IMenuItem menuItem, String addOnName, float addOnPrice) {
        this.menuItem = menuItem;
        this.addOnName = addOnName;
        this.addOnPrice = addOnPrice;
    }
   @Override
    public String getName() {
        return menuItem.getName() + " + " + addOnName;
    }
    @Override
    public float getPrice() {
        return menuItem.getPrice() + addOnPrice;
    }
    @Override
    public String getId() {
        return menuItem.getId();
    }
    @Override
    public String getAddOnName() {
        return addOnName;
    }
    @Override
    public float getAddOnPrice() {
        return addOnPrice;
    }
    public IMenuItem getWrappedItem() {
        return menuItem;
    }
}