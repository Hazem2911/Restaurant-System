package Menu.AddOnDecorator;

import Menu.IMenuItem;

public class SauceAddOn extends AddOnDecorator {
    public SauceAddOn(IMenuItem menuItem) {
        super(menuItem, "Extra Sauce", 0.50f);
    }
}