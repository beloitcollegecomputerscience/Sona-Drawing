package com.example.mydrawingstructure;

/*import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;*/

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static org.junit.Assert.*;
import static sun.util.locale.LocaleMatcher.lookup;

import javafx.application.Application;

public class Circular_Arcs_Test extends Application {

    public static void main(String[] args) {
        Arc arc1 = lookup("#arc1").query();
        Arc arc2 = lookup("#arc2").query();
        Arc arc3 = lookup("#arc3").query();
        Arc arc4 = lookup("#arc4").query();

        assertNotNull(arc1);
        assertNotNull(arc2);
        assertNotNull(arc3);
        assertNotNull(arc4);

    }

    @Override
    public void start(Stage primaryStage) {

        Arc arc1 = lookup("#arc1").query();
        Arc arc2 = lookup("#arc2").query();
        Arc arc3 = lookup("#arc3").query();
        Arc arc4 = lookup("#arc4").query();

        assertEquals(50.0, arc1.getRadiusX(), 0.01);
        assertEquals(75.0, arc2.getRadiusX(), 0.01);
        assertEquals(100.0, arc3.getRadiusX(), 0.01);
        assertEquals(125.0, arc4.getRadiusX(), 0.01);

        assertEquals(90.0, arc1.getStartAngle(), 0.01);
        assertEquals(0.0, arc2.getStartAngle(), 0.01);
        assertEquals(45.0, arc3.getStartAngle(), 0.01);
        assertEquals(180.0, arc4.getStartAngle(), 0.01);

        assertEquals(180.0, arc1.getLength(), 0.01);
        assertEquals(90.0, arc2.getLength(), 0.01);
        assertEquals(135.0, arc3.getLength(), 0.01);
        assertEquals(360.0, arc4.getLength(), 0.01);

        assertEquals(ArcType.OPEN, arc1.getType());
        assertEquals(ArcType.OPEN, arc2.getType());
        assertEquals(ArcType.OPEN, arc3.getType());
        assertEquals(ArcType.OPEN, arc4.getType());

        assertEquals(Color.BLACK, arc1.getStroke());
        assertEquals(Color.RED, arc2.getStroke());
        assertEquals(Color.BLUE, arc3.getStroke());
        assertEquals(Color.GREEN, arc4.getStroke());

        assertEquals(null, arc1.getFill());
        assertEquals(null, arc2.getFill());
        assertEquals(null, arc3.getFill());
        assertEquals(null, arc4.getFill());

    }
}
