package application;

import canvas.canvas_switching;
import controller.Controller;
import controller.Controller.CursorMode;
import gui.GUI;
import helperClasses.ClickOperation;
import initialSetup.DotsPosition;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GUI.getInstance().showWindow(stage);
        DotsPosition dp = new DotsPosition();
        canvas_switching cs = new canvas_switching();

        // Example code
        GraphicsContext gc = Controller.getGraphicsContext();
        Controller.doOnCanvasClick(new ClickOperation(CursorMode.DOTS, click -> {
            // Make sure you get the height and width in here if you're expecting them to change!
            int width = Controller.getCursorWidth();
            int height = Controller.getCursorHeight();
            int i = click.x;
            int j = click.y;
            System.out.println(i);
            System.out.println(j);
            ArrayList<int[]> dots_pixel_coordinate = new ArrayList<>();
            dp.add(new int[]{i,j}, height, width);

            for (int a = 0; a < dp.dots_coordinate.size(); a++) {
                dots_pixel_coordinate.add(cs.StructuralCanvas_to_PixelCanvas(dp.dots_coordinate.get(a)));
            }

            for (int b = 0; b < dots_pixel_coordinate.size(); b++) {
                gc.fillOval(dots_pixel_coordinate.get(b)[0], dots_pixel_coordinate.get(b)[1], 5, 5);
            }


            System.out.println(Arrays.deepToString(dots_pixel_coordinate.toArray()));


//             // x2 to make rectangles bigger, for demonstration
        }));
//
//        Stub s = new Stub();
//        s.example();
    }
}