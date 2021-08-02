package com.rainmonth.pattern.structural.flyweight;

/**
 * @author randy
 * @date 2021/7/30 1:52 下午
 */
public class FlyWeightDemo {
    private static final String[] colors = new String[]{"Red", "Green", "Blue", "Black", "Purple"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
