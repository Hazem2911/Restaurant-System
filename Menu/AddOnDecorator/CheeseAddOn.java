package Menu.AddOnDecorator;

import Menu.IMenuItem;

public class CheeseAddOn extends AddOnDecorator {
    public CheeseAddOn(IMenuItem menuItem) {
        super(menuItem, "Extra Cheese", 1.00f);
    }
}