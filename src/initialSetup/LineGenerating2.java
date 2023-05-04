package src.initialSetup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class LineGenerating2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Line Drawing Examples");
        Line line1 = new Line(10,50,150,50); //Line(startX,startY,endX,endY)      
        Line line2 = new Line(10,100,150,100);
        Line line3 = new Line(10,50,10,100);
        Line line4 = new Line(150,50,150,100);
        Group root = new Group();
        root.getChildren().addAll(line1,line2,line3,line4);
        Scene scene = new Scene (root,300,200,Color.GREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}  