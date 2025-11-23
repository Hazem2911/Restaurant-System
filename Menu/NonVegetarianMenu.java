package Menu;

import java.util.List;
import java.util.ArrayList;

public class NonVegetarianMenu implements IMenu {
    private final String menuType = "NonVegetarian";
    private final List<IMenuItem> items = new ArrayList<>();

    public NonVegetarianMenu() {
        items.add(new MenuItem("N-01", "Chicken Pizza", 9.50f, "Pizza"));
        items.add(new MenuItem("N-02", "Grilled Chicken Salad", 6.50f, "Salad"));
        items.add(new MenuItem("N-03", "Classic Chicken Burger", 7.50f, "Burger"));
    }

    @Override public String getMenuType() { return menuType; }
    @Override public List<IMenuItem> getItems() { return items; }
}