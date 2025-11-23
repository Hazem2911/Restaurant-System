package Menu;

import java.util.List;
import java.util.ArrayList;

public class VegetarianMenu implements IMenu {
    private final String menuType = "Vegetarian";
    private final List<IMenuItem> items = new ArrayList<>();

    public VegetarianMenu() {
        items.add(new MenuItem("V-01", "Margherita Pizza", 8.50f, "Pizza"));
        items.add(new MenuItem("V-02", "Garden Salad", 5.00f, "Salad"));
        items.add(new MenuItem("V-03", "Veg Burger", 6.50f, "Burger"));
    }

    @Override public String getMenuType() { return menuType; }
    @Override public List<IMenuItem> getItems() { return items; }
}