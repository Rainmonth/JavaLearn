package com.rainmonth.pattern.behavioral.strategy.duck;

public class Float implements SwimBehavior {

    @Override
    public void swim() {
        System.out.println("float");
    }
}
