package Menu;

public class MenuItem implements IMenuItem {
    private final String id;
    private final String name;
    private final float basePrice;
    private final String category;

    public MenuItem(String id, String name, float basePrice, String category) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    @Override
    public String getId() { return id; }
    @Override
    public String getName() { return name; }
    @Override
    public float getPrice() { return basePrice; }
    public String getCategory() { return category; }
}