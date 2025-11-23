package Ordering.Observer;

import java.util.List;
import java.util.ArrayList;

/**
 * Concrete subject for order-related events.
 */
public class OrderSubject implements ISubject {
    private final List<IObserver> observers = new ArrayList<>();
    private String latestUpdate;

    @Override
    public void registerObserver(IObserver observer) {
        if (observer == null) return;
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver o : new ArrayList<>(observers)) {
            o.update();
        }
    }

    @Override
    public String getUpdate() {
        return latestUpdate;
    }

    @Override
    public void setOrderUpdate(String update) {
        this.latestUpdate = update;
        notifyObservers();
    }
}