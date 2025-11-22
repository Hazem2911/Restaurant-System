public class KitchenDisplay implements IObserver {
    private ISubject subject;

    public KitchenDisplay(ISubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("KitchenDisplay: An update has been received from the subject.");
    }
}