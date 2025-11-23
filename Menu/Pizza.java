package Menu;

public class Pizza extends MenuItem {
    private final String size;
    private final boolean vegetarian;

    public Pizza(String id, String name, float basePrice, String size, boolean vegetarian) {
        super(id, name, basePrice, "Pizza");
        this.size = size;
        this.vegetarian = vegetarian;
    }

    public String getSize() { return size; }
    public boolean isVegetarian() { return vegetarian; }
}