
package com.rainmonth.pattern.behavioral.strategy.duck;

public class MallardDuck extends Duck {
    
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
        swimBehavior = new SwimWithWebbedFeet();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
