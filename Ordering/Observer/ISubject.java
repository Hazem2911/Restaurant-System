package Ordering.Observer;

import java.util.List;

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();

    // return a simple string describing the latest update; observers pull this
    String getUpdate();

    // allow subjects to accept a new update (used by Order.place())
    void setOrderUpdate(String update);
}