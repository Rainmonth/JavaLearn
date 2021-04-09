package com.rainmonth.pattern.structural.bridge.drawing;

public class DP2 {

    public static void draw_line(double x1, double x2, double y1, double y2) {
        System.out.println(String.format("DP2 draw line, (%s, %s) -> (%s, %s)", x1, y1, x1, y2));
        System.out.println(String.format("DP2 draw line, (%s, %s) -> (%s, %s)", x1, y2, x2, y2));
        System.out.println(String.format("DP2 draw line, (%s, %s) -> (%s, %s)", x2, y2, x2, y1));
        System.out.println(String.format("DP2 draw line, (%s, %s) -> (%s, %s)", x2, y1, x1, y1));
        System.out.println();
    }

    public static void draw_circle(double x, double y, double r) {
        System.out.println(String.format("DP2 draw circle, center: (%s, %s), radius: %s", x, y ,r));
        System.out.println();
    }
}
