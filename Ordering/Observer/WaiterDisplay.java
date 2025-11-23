package Ordering.Observer;

public class WaiterDisplay implements IObserver {
    private ISubject subject;

    public WaiterDisplay(ISubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("WaiterDisplay: update -> " + subject.getUpdate());
        // Additional display logic can be implemented here
    }
}