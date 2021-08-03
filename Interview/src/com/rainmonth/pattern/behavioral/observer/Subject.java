
package com.rainmonth.pattern.behavioral.observer;

/**
 * 被观察者接口
 */
public interface Subject {
    void registerObserver(Observer object);

    void removeObserver(Observer object);

    void notifyObservers();
}
