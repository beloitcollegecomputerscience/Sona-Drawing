package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class Circular_Arcs_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a new arc with a radius of 50
        Arc arc1 = new Arc(100, 100, 50, 50, 90, 180);
        arc1.setType(ArcType.OPEN);
        arc1.setStroke(Color.BLACK);
        arc1.setFill(null);

        // Create a new arc with a radius of 75
        Arc arc2 = new Arc(100, 100, 75, 75, 0, 90);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.RED);
        arc2.setFill(null);

        // Create a new arc with a radius of 100
        Arc arc3 = new Arc(100, 100, 100, 100, 45, 135);
        arc3.setType(ArcType.OPEN);
        arc3.setStroke(Color.BLUE);
        arc3.setFill(null);

        // Create a new arc with x radius of 50 and y radius of 75
        Arc arc4 = new Arc(100, 100, 50, 75, 180, 360);
        arc4.setType(ArcType.OPEN);
        arc4.setStroke(Color.GREEN);
        arc4.setFill(null);

        // Add the arcs to a pane and set the pane as the scene
        Pane pane = new Pane(arc1, arc2, arc3, arc4);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        double centerX = 150;
        double centerY = 150;
        double radius1 = 50;
        double radius2 = 75;
        double radius3 = 100;
        double radius4 = 125;
        double arcSpacing = 10;

        // Create a new arc with a radius of 50
        Arc arc1 = new Arc(centerX - radius1 - arcSpacing, centerY, radius1, radius1, 90, 180);
        arc1.setType(ArcType.OPEN);
        arc1.setStroke(Color.BLACK);
        arc1.setFill(null);

        // Create a new arc with a radius of 75
        Arc arc2 = new Arc(centerX + radius2 + arcSpacing, centerY, radius2, radius2, 0, 90);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.RED);
        arc2.setFill(null);

        // Create a new arc with a radius of 100
        Arc arc3 = new Arc(centerX, centerY - radius3 - arcSpacing, radius3, radius3, 45, 135);
        arc3.setType(ArcType.OPEN);
        arc3.setStroke(Color.BLUE);
        arc3.setFill(null);

        // Create a new arc with a radius of 125
        Arc arc4 = new Arc(centerX, centerY + radius4 + arcSpacing, radius4, radius4, 180, 360);
        arc4.setType(ArcType.OPEN);
        arc4.setStroke(Color.GREEN);
        arc4.setFill(null);

        // Add the arcs to a pane and set the pane as the scene
        Pane pane = new Pane(arc1, arc2, arc3, arc4);
        Scene scene = new Scene(pane, 350, 400);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }
}