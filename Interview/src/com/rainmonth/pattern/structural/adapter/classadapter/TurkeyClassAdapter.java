package com.rainmonth.pattern.structural.adapter.classadapter;

import com.rainmonth.pattern.structural.adapter.Duck;
import com.rainmonth.pattern.structural.adapter.WildTurkey;

public class TurkeyClassAdapter extends WildTurkey implements Duck {

    @Override
    public void quack() {
        super.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            super.fly();
        }
    }

}
