package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 1:59 下午
 */
public class Square extends Shape{
    @Override
    public void draw() {
        color.paint("正方形");
    }
}
