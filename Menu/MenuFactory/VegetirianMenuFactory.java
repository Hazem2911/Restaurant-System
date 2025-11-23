package Menu.MenuFactory;

import Menu.IMenu;
import Menu.VegetarianMenu;

public class VegetirianMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new VegetarianMenu();
    }
}