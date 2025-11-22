public class NotificationService  {
    private ISubject subject;

    public NotificationService(ISubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("NotificationService: An update has been received from the subject.");
        // Additional notification logic can be implemented here
    }
}