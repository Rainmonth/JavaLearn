
package com.rainmonth.pattern.behavioral.observer;

public interface Subject {
    public void registerObserver(Observer object);

    public void removeObserver(Observer object);

    public void notifyObservers();
}
