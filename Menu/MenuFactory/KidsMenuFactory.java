public class KidsMenuFactory implements IMenuFactory {
    @Override
    public IMenu createMenu() {
        return new KidsMenu();
    }
}