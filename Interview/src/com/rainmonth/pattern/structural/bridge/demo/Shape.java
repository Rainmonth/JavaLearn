package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 1:54 下午
 */
public abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
