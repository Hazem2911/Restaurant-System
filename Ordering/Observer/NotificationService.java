package Ordering.Observer;

public class NotificationService implements IObserver {
    private ISubject subject;

    public NotificationService(ISubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("NotificationService: update -> " + subject.getUpdate());
        // Additional notification logic (e.g. push / SMS) can be added here
    }
}