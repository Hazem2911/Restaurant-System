public class Salad extends MenuItem {
    public string name;
    public float price;
    public string dressingType;
    public bool isVegan;

    public Salad(string name, float price, string dressingType, bool isVegan) {
        this.name = name;
        this.price = price;
        this.dressingType = dressingType;
        this.isVegan = isVegan;
    }
}