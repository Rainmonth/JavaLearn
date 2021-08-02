package com.rainmonth.pattern.structural.adapter.demo;

/**
 * @author randy
 * @date 2021/7/16 6:06 下午
 */
public class PigClassAdapter extends Pig implements FlyAnimal{
    @Override
    public String flyKindName() {
        return super.crawlKindName();
    }

    @Override
    public void fly() {
        super.crawl();
    }
}
