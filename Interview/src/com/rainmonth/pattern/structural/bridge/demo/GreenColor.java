package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 1:58 下午
 */
public class GreenColor implements Color {
    @Override
    public String colorName() {
        return "绿色的";
    }

    @Override
    public void paint(String shapeName) {
        System.out.println(colorName() + shapeName);
    }
}
