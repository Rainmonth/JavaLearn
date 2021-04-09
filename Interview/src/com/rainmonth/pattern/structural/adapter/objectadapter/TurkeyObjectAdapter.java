package com.rainmonth.pattern.structural.adapter.objectadapter;

import com.rainmonth.pattern.structural.adapter.Duck;
import com.rainmonth.pattern.structural.adapter.Turkey;

public class TurkeyObjectAdapter implements Duck {

    private Turkey turkey;

    public TurkeyObjectAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

}
