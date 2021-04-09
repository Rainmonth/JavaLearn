
package com.rainmonth.pattern.behavioral.strategy.duck;

public class SwimWithTurbineEngine implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("swim with turbine engine");
    }
}
