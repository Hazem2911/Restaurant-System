public class Pizza extends MenuItem {
    public string name;
    public float price;
    public string size;
    public bool isVegetarian;

    public Pizza(string name, float price, string size, bool isVegetarian) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.isVegetarian = isVegetarian;
    }
}