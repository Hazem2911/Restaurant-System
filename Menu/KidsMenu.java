package Menu;

import java.util.List;
import java.util.ArrayList;

public class KidsMenu implements IMenu {
    private final String menuType = "Kids";
    private final List<IMenuItem> items = new ArrayList<>();

    public KidsMenu() {
        items.add(new MenuItem("K-01", "Mini Margherita", 4.50f, "Pizza"));
        items.add(new MenuItem("K-02", "Kids Salad", 3.50f, "Salad"));
        items.add(new MenuItem("K-03", "Kids Burger", 4.00f, "Burger"));
    }

    @Override public String getMenuType() { return menuType; }
    @Override public List<IMenuItem> getItems() { return items; }
}