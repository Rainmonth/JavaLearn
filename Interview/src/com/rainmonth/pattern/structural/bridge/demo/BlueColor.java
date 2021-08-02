package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 2:01 下午
 */
public class BlueColor implements Color {
    @Override
    public String colorName() {
        return "蓝色的";
    }

    @Override
    public void paint(String shapeName) {
        System.out.println(colorName() + shapeName);
    }
}
