package Menu;

import java.util.List;
import java.util.ArrayList;

public class MenuRepo {
    private final List<Menu> menus;

    public MenuRepo() {
        this.menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        if (menu == null) return;
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Menu loadMenu(String type) {
        if (type == null) return null;
        for (Menu m : menus) {
            if (type.equalsIgnoreCase(m.getMenuType())) return m;
        }
        return null;
    }
}