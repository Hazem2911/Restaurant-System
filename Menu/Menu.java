package Menu;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private final String menuType;
    private final List<IMenuItem> items;

    public Menu(String menuType, List<? extends IMenuItem> items) {
        this.menuType = menuType;
        this.items = new ArrayList<>(items);
    }

    public String getMenuType() {
        return menuType;
    }

    public List<IMenuItem> getItems() {
        return items;
    }
}