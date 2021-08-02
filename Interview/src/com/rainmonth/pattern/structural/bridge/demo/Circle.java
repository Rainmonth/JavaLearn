package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 1:55 下午
 */
public class Circle extends Shape{
    @Override
    public void draw() {
        color.paint("圆");
    }
}
