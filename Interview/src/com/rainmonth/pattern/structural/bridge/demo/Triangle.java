package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 2:00 下午
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        color.paint("三角形");
    }
}
