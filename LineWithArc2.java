package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

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
            Scene scene = new Scene(root, 400, 400, Color.AZURE);

            Group arcWithLine1 = drawArcWithLine(50, 50);
            Group arcWithLine2 = drawArcWithLine(200, 150);

            root.getChildren().addAll(arcWithLine1, arcWithLine2);

            primaryStage.setScene(scene);
            primaryStage.show();

    }


}
