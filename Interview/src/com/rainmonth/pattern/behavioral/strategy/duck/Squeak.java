
package com.rainmonth.pattern.behavioral.strategy.duck;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
    
}
