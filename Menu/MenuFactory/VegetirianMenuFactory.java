public class VegetirianMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new VegetirianMenu();
    }
}