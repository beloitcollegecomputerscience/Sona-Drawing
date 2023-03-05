package com.example.mydrawingstructure;

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

    }
