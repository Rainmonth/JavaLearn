package com.rainmonth.pattern.structural.adapter.demo;

/**
 * @author randy
 * @date 2021/7/16 5:57 下午
 */
public class Bird implements FlyAnimal {
    @Override
    public String flyKindName() {
        return "My kind is Bird";
    }

    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
