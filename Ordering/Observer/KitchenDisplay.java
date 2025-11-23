package Ordering.Observer;

public class KitchenDisplay implements IObserver {
    private ISubject subject;

    public KitchenDisplay(ISubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("KitchenDisplay: update -> " + subject.getUpdate());
    }
}