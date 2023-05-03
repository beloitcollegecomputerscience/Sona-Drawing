package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

//testing code commented out
/*import static org.junit.jupiter.api.Assertions.*;
//
//import javafx.scene.Group;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Iterator; */


public class LineWithArc2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Group drawArcWithLine(double startX, double startY) {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(startX + 100);
        line.setEndY(startY);

        Arc arc = new Arc();
        arc.setCenterX(line.getEndX() + 40);
        arc.setCenterY(startY);
        arc.setRadiusX(58);
        arc.setRadiusY(45);
        arc.setStartAngle(0);
        arc.setLength(90);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);

        line.setEndX(arc.getCenterX());
        line.setEndY(arc.getCenterY() - arc.getRadiusY());

        Group group = new Group();
        group.getChildren().addAll(line, arc);
        return group;
    }


    @Override
    public void start(Stage primaryStage) {
            primaryStage.setTitle("Arc with Line in JavaFX");

            Group root = new Group();
            Iterator<Shape> it = (getIterator(collection()));
            while(it.hasNext()) {
                root.getChildren().add(it.next());
            }
            Scene scene = new Scene(root, 400, 400, Color.AZURE);

            Group arcWithLine1 = drawArcWithLine(50, 50);
            Group arcWithLine2 = drawArcWithLine(200, 150);

            root.getChildren().addAll(arcWithLine1, arcWithLine2);

            primaryStage.setScene(scene);
            primaryStage.show();

    }

    public static ArrayList<Shape> collection() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Line(100, 50 ,90, 200));
        shapes.add(new Line(90, 200 ,180, 40));
        shapes.add(new Line(180, 40 ,240, 280));
        shapes.add(new Line(90, 180 ,389, 240));
        return shapes;
    }
    public static Iterator<Shape> getIterator(ArrayList<Shape> shapes){
        Iterator<Shape> iter = shapes.iterator();
        return iter;
    }





/*public class LineWithArc2Test {

    @Test
    public void testDrawArcWithLine() {
        LineWithArc2 app = new LineWithArc2();

        // Test the drawArcWithLine method with start coordinates of (50, 50)
        Group expectedGroup1 = new Group();
        Shape expectedLine1 = new javafx.scene.shape.Line(50, 50, 150, 50);
        Shape expectedArc1 = new javafx.scene.shape.Arc(190, 50, 58, 45, 0, 90);
        expectedArc1.setType(javafx.scene.shape.ArcType.OPEN);
        expectedArc1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        expectedArc1.setStroke(javafx.scene.paint.Color.BLACK);
        expectedLine1.setEndX(190);
        expectedLine1.setEndY(5.0);
        expectedGroup1.getChildren().addAll(expectedLine1, expectedArc1);

        Group actualGroup1 = app.drawArcWithLine(50, 50);
        assertEquals(expectedGroup1.getChildren().size(), actualGroup1.getChildren().size());
        assertEquals(expectedGroup1.getChildren(), actualGroup1.getChildren());

        // Test the drawArcWithLine method with start coordinates of (200, 150)
        Group expectedGroup2 = new Group();
        Shape expectedLine2 = new javafx.scene.shape.Line(200, 150, 300, 150);
        Shape expectedArc2 = new javafx.scene.shape.Arc(340, 150, 58, 45, 0, 90);
        expectedArc2.setType(javafx.scene.shape.ArcType.OPEN);
        expectedArc2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        expectedArc2.setStroke(javafx.scene.paint.Color.BLACK);
        expectedLine2.setEndX(340);
        expectedLine2.setEndY(105.0);
        expectedGroup2.getChildren().addAll(expectedLine2, expectedArc2);

        Group actualGroup2 = app.drawArcWithLine(200, 150);
        assertEquals(expectedGroup2.getChildren().size(), actualGroup2.getChildren().size());
        assertEquals(expectedGroup2.getChildren(), actualGroup2.getChildren());
    }

    @Test
    public void testCollection() {
        ArrayList<Shape> expectedShapes = new ArrayList<>();
        expectedShapes.add(new javafx.scene.shape.Line(100, 50 ,90, 200));
        expectedShapes.add(new javafx.scene.shape.Line(90, 200 ,180, 40));
        expectedShapes.add(new javafx.scene.shape.Line(180, 40 ,240, 280));
        expectedShapes.add(new javafx.scene.shape.Line(90, 180 ,389, 240));

        ArrayList<Shape> actualShapes = LineWithArc2.collection();
        assertEquals(expectedShapes.size(), actualShapes.size());
        assertEquals(expectedShapes, actualShapes);
    }

    @Test
    public void testGetIterator() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new javafx.scene.shape.Line(100, 50 ,90, 200));
        shapes.add(new javafx.scene.shape.Line(90, 200 ,180, 40));
        shapes.add(new javafx.scene.shape.Line(180, 40 ,240, 280));
        shapes.add(new javafx.scene.shape.Line(90, 180 ,389, 240));

        Iterator<Shape> expectedIterator = shapes.iterator(); */



}
