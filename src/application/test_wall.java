package src.initialSetup;
package application;

import canvas.canvas_switching;
import controller.Controller;
import controller.Controller.CursorMode;
import gui.GUI;
import helperClasses.ClickOperation;
import initialSetup.WallsPosition;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class test_wall  extends Application{

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {

            GUI.getInstance().showWindow(stage);
            WallsPosition dp = new WallsPosition();
            canvas_switching cs = new canvas_switching();

            // Example code
            GraphicsContext gc = Controller.getGraphicsContext();
            Controller.doOnCanvasClick(new ClickOperation(CursorMode.WALLS, click -> {
                // Make sure you get the height and width in here if you're expecting them to change!
                int i = click.x;
                int j = click.y;
                System.out.println(i);
                System.out.println(j);
                ArrayList<int[]> dots_pixel_coordinate = new ArrayList<>();
                dp.add(new int [] {i,j});

                for (int a = 0; a < dp.walls_coordinate.size(); a++) {
                    dots_pixel_coordinate.add(cs.StructuralCanvas_to_PixelCanvas(dp.walls_coordinate.get(a)));
                }

                for (int b = 0; b < dots_pixel_coordinate.size(); b++) {
                    gc.fillOval(dots_pixel_coordinate.get(b)[0], dots_pixel_coordinate.get(b)[1], 5, 5);
                }
                System.out.println(Arrays.deepToString(dots_pixel_coordinate.toArray()));

            }));

        }
    }

}
