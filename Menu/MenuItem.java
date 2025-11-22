public class MenuItem extends IMenuItem {
    public string name;
    public float price;
    public string category;
    public int ID;

    public MenuItem(string name, float price, string category, int ID) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = ID;
    }
}