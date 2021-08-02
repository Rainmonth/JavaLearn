package com.rainmonth.pattern.structural.bridge.demo;

/**
 * @author randy
 * @date 2021/7/22 2:01 下午
 */
public class Client {
    public static void main(String[] args) {
        // 蓝色的圆
        Shape circle = new Circle();
        circle.setColor(new BlueColor());
        circle.draw();

        // 红色的正方形
        Shape square = new Square();
        square.setColor(new RedColor());
        square.draw();

        // 绿色的三角形
        Shape triangle = new Triangle();
        triangle.setColor(new GreenColor());
        triangle.draw();
    }
}
