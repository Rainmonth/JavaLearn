package com.rainmonth.pattern.structural.adapter.demo;

/**
 * @author randy
 * @date 2021/7/16 6:04 下午
 */
public class PigObjectAdapter implements FlyAnimal{
    private Pig pig;

    public PigObjectAdapter(Pig pig) {
        this.pig = pig;
    }

    @Override
    public String flyKindName() {
        return pig.crawlKindName();
    }

    @Override
    public void fly() {
        pig.crawl();
    }
}
