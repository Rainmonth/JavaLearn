package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 1:57 下午
 */
public class RedColor implements Color {

    @Override
    public String colorName() {
        return "红色的";
    }

    @Override
    public void paint(String shapeName) {
        System.out.println(colorName() + shapeName);
    }
}
