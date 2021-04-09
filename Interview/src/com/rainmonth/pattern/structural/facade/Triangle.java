package com.rainmonth.pattern.structural.facade;

public class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle::draw()");
    }
}
