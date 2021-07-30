package com.rainmonth.pattern.structural.flyweight;

/**
 * @author randy
 * @date 2021/7/30 1:46 下午
 */
public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }
// 这里注释掉setColor方法，不然外界拿到对象后可以调用该方法来改变Circle颜色
//    public void setColor(String color) {
//        this.color = color;
//    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: draw()[" + "color=" + color + ", x=" + x + ", y=" + y + ", radius=" + radius + ']');
    }
}
