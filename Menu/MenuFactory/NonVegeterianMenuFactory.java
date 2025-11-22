public class NonVegeterianMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new NonVegeterianMenu();
    }
}