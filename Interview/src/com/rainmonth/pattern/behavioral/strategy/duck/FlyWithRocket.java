
package com.rainmonth.pattern.behavioral.strategy.duck;

public class FlyWithRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I'm fly with rocket!!");
    }
    
}
