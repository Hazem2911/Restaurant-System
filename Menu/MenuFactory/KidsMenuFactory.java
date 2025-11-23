package Menu.MenuFactory;

import Menu.IMenu;
import Menu.KidsMenu;

public class KidsMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new KidsMenu();
    }
}