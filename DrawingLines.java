package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Lines in javaFx");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.AZURE);

        //Common Line
        Line line = new Line();
        line.setStartX(50); // x-coordinate of the start point
        line.setStartY(50); // y-coordinate of the start point
        line.setEndX(200); // x-coordinate of the end point
        line.setEndY(50); // y-coordinate of the end point
        line.setStroke(Color.BLACK); // set line color

        root.getChildren().add(line); // add the line to the root group


        //Dashed Line
        Line line1 = new Line();
        line1.setStartX(50);
        line1.setStartY(50);
        line1.setEndX(250);
        line1.setEndY(250);
        line1.setStroke(Color.CORAL);

        // Set the dash pattern
        line1.getStrokeDashArray().addAll(10d, 5d);

        root.getChildren().add(line1);



        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
