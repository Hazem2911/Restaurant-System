package Menu;

public class Burger extends MenuItem {
    private final String bunType;
    private final boolean hasCheese;

    public Burger(String id, String name, float basePrice, String bunType, boolean hasCheese) {
        super(id, name, basePrice, "Burger");
        this.bunType = bunType;
        this.hasCheese = hasCheese;
    }

    public String getBunType() { return bunType; }
    public boolean hasCheese() { return hasCheese; }
}