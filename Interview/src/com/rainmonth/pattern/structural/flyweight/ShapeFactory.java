package com.rainmonth.pattern.structural.flyweight;

import java.util.HashMap;

/**
 * @author randy
 * @date 2021/7/30 1:48 下午
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("----------------------------------");
            System.out.println("create circle of color:" + color);
            System.out.println("----------------------------------");
        }
        return circle;
    }
}
