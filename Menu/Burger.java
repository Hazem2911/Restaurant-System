public class Burger extends MenuItem {
    public string name;
    public float price;
    public string bunType;
    public bool hasCheese;

    public Burger(string name, float price, string bunType, bool hasCheese) {
        this.name = name;
        this.price = price;
        this.bunType = bunType;
        this.hasCheese = hasCheese;
    }
}