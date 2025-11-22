public class MenuRepo {
    private List<Menu> menus;

    public MenuRepo() {
        this.menus = new List<Menu>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}