package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLineWithArc extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Arcs with Line Segments in JavaFX");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.AZURE);

        // Draw first arc with line segment
        Group arcWithLine1 = drawArcWithLine(50, 100);
        arcWithLine1.getChildren().get(0).setStyle(String.valueOf(Color.BLUE));
        arcWithLine1.getChildren().get(1).setStyle(String.valueOf(Color.GREEN));
        root.getChildren().add(arcWithLine1);

        // Draw second arc with line segment
        Group arcWithLine2 = drawArcWithLine(200, 300);
        arcWithLine2.getChildren().get(0).setStyle(String.valueOf(Color.ORANGE));
        arcWithLine2.getChildren().get(1).setStyle(String.valueOf(Color.PURPLE));
        root.getChildren().add(arcWithLine2);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Group drawArcWithLine(double startX, double startY) {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(startX + 100);
        line.setEndY(startY);

        Arc arc = new Arc();
        arc.setCenterX(line.getEndX() + 50);
        arc.setCenterY(startY);
        arc.setRadiusX(50);
        arc.setRadiusY(50);
        arc.setStartAngle(0);
        arc.setLength(180);
        arc.setType(ArcType.OPEN);

        line.setEndX(arc.getCenterX());
        line.setEndY(arc.getCenterY() - arc.getRadiusY());

        Group group = new Group();
        group.getChildren().addAll(line, arc);


        return group;
    }



    }

