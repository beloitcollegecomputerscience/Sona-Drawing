package src.initialSetup;


import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Liness extends Application {

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Iterator<Shape> it = (getIterator(collection()));
        while (it.hasNext()) {
            root.getChildren().add(it.next());
        }

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Collection of Lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Shape> collection() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Line(20, 20, 90, 150));
        shapes.add(new Line(190, 150, 80, 140));
        shapes.add(new Line(80, 140, 90, 180));
        shapes.add(new Line(90, 180, 389, 240));
        shapes.add(new Arc(100.0f, 100.0f, 100.0f, 100.0f, 0.0f, 40.0f));
        return shapes;
    }

    public static Iterator<Shape> getIterator(ArrayList<Shape> shapes) {
        Iterator<Shape> iter = shapes.iterator();
        return iter;
    }

}
