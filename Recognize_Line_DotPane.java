package com.example.mydrawingstructure;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recognize_Line_DotPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Define the layout
        Pane pane = new Pane();

        // Add the necessary dots
        Circle dot1 = new Circle(50, 50, 10);
        Circle dot2 = new Circle(150, 150, 10);
        Circle dot3 = new Circle(200, 50, 10);

        // Define the connections
        Map<Circle, List<Circle>> connections = new HashMap<>();
        connections.put(dot1, Arrays.asList(dot2, dot3));
        connections.put(dot2, Arrays.asList(dot1, dot3));
        connections.put(dot3, Arrays.asList(dot1, dot2));

        // Calculate the paths
        Map<Circle, Map<Circle, List<Point2D>>> paths = new HashMap<>();
        for (Circle start : connections.keySet()) {
            Map<Circle, List<Point2D>> pathsFromStart = new HashMap<>();
            paths.put(start, pathsFromStart);
            for (Circle end : connections.get(start)) {
                Object Pathfinding;
                List<Point2D> path = Pathfinding.calculatePath(start.getCenterX(), start.getCenterY(), end.getCenterX(), end.getCenterY(), connections, pane);
                pathsFromStart.put(end, path);
            }
        }

        // Draw the lines
        for (Circle start : paths.keySet()) {
            for (Circle end : paths.get(start).keySet()) {
                List<Point2D> path = paths.get(start).get(end);
                for (int i = 0; i < path.size() - 1; i++) {
                    Line line = new Line(path.get(i).getX(), path.get(i).getY(), path.get(i + 1).getX(), path.get(i + 1).getY());
                    pane.getChildren().add(line);
                }
            }
        }

        // Position the dots in the pane
        pane.getChildren().addAll(dot1, dot2, dot3);
        pane.setPadding(new Insets(10));
        pane.setPrefSize(250, 200);
        pane.setMargin(dot1, new Insets(50, 0, 0, 50));

        // Create a scene and add the pane to it
        Scene scene = new Scene(pane);

        // Set the scene on the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}