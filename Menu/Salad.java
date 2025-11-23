package Menu;

public class Salad extends MenuItem {
    private final String dressingType;
    private final boolean vegan;

    public Salad(String id, String name, float basePrice, String dressingType, boolean vegan) {
        super(id, name, basePrice, "Salad");
        this.dressingType = dressingType;
        this.vegan = vegan;
    }

    public String getDressingType() { return dressingType; }
    public boolean isVegan() { return vegan; }
}