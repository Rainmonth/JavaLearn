package com.rainmonth.pattern.behavioral.strategy.duck;

public class SwimWithWebbedFeet implements SwimBehavior {

    @Override
    public void swim() {
        System.out.println("swim with webbed feet");
    }

}
