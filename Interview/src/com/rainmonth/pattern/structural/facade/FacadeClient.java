package com.rainmonth.pattern.structural.facade;

public class FacadeClient {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.draw();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawTriangle();
    }
}
