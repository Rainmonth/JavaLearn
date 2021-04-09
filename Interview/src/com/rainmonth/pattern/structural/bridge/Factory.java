package com.rainmonth.pattern.structural.bridge;

import com.rainmonth.pattern.structural.bridge.drawing.Drawing;
import com.rainmonth.pattern.structural.bridge.drawing.V1Drawing;
import com.rainmonth.pattern.structural.bridge.drawing.V2Drawing;
import com.rainmonth.pattern.structural.bridge.shape.Circle;
import com.rainmonth.pattern.structural.bridge.shape.Rectangle;
import com.rainmonth.pattern.structural.bridge.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    private List<Shape> shapes = new ArrayList<Shape>();

    public Factory() {
    }

    public void create() {
        Drawing v1Drawing = new V1Drawing();
        Drawing v2Drawing = new V2Drawing();

        shapes.add(new Rectangle(v1Drawing, 2, 2, 5, 5));
        shapes.add(new Circle(v1Drawing, 2, 2, 5));
        shapes.add(new Rectangle(v2Drawing, 1, 1, 7, 7));
        shapes.add(new Circle(v2Drawing, 3, 3, 6));
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
