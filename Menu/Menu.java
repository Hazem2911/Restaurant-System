public class Menu {
    public string menuType;
    public List<MenuItem> items;

    public Menu(string menuType, List<MenuItem> items) {
        this.menuType = menuType;
        this.items = items;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}