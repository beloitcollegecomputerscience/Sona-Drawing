package com.example.mydrawingstructure;
//Copy code
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

public class DrawingCircularArcs extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing a Circular Arc in JavaFX");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.AZURE);

        // Create a circular arc1
        Arc arc = new Arc();
        arc.setCenterX(200);
        arc.setCenterY(200);
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setStartAngle(45);
        arc.setLength(90);
        arc.setStroke(Color.BLACK);
        arc.setFill(null);

        root.getChildren().add(arc);

        primaryStage.setScene(scene);
        primaryStage.show();


        // Circular arc1 with different center and radius values
        Arc arc1= new Arc();
        arc1.setCenterX(100);
        arc1.setCenterY(300);
        arc1.setRadiusX(50);
        arc1.setRadiusY(75);
        arc1.setStartAngle(135);
        arc1.setLength(180);
        arc1.setStroke(Color.RED);
        arc1.setFill(null);

        root.getChildren().add(arc1);

        primaryStage.setScene(scene);
        primaryStage.show();

        //
    }


    //public class DrawingCircularArcsTest {
    //
    //    @Test
    //    public void testArcProperties() {
    //        DrawingCircularArcs app = new DrawingCircularArcs();
    //        Stage stage = new Stage();
    //        app.start(stage);
    //
    //        Scene scene = stage.getScene();
    //        assertNotNull(scene);
    //
    //        // check properties of the first arc
    //        Arc arc = (Arc) scene.getRoot().getChildrenUnmodifiable().get(0);
    //        assertEquals(200, arc.getCenterX());
    //        assertEquals(200, arc.getCenterY());
    //        assertEquals(100, arc.getRadiusX());
    //        assertEquals(100, arc.getRadiusY());
    //        assertEquals(45, arc.getStartAngle());
    //        assertEquals(90, arc.getLength());
    //        assertEquals(Color.BLACK, arc.getStroke());
    //        assertNull(arc.getFill());
    //
    //        // check properties of the second arc
    //        Arc arc1 = (Arc) scene.getRoot().getChildrenUnmodifiable().get(1);
    //        assertEquals(100, arc1.getCenterX());
    //        assertEquals(300, arc1.getCenterY());
    //        assertEquals(50, arc1.getRadiusX());
    //        assertEquals(75, arc1.getRadiusY());
    //        assertEquals(135, arc1.getStartAngle());
    //        assertEquals(180, arc1.getLength());
    //        assertEquals(Color.RED, arc1.getStroke());
    //        assertNull(arc1.getFill());
    //    }
    //}
    }
