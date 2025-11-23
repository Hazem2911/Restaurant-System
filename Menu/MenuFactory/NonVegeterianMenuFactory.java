package Menu.MenuFactory;

import Menu.IMenu;
import Menu.NonVegetarianMenu;

public class NonVegeterianMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new NonVegetarianMenu();
    }
}