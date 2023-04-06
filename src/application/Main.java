package application;

import controller.Controller;
import controller.Controller.CursorMode;
import gui.GUI;
import helperClasses.ClickOperation;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		GUI.getInstance().showWindow(stage);

		// Example code
		GraphicsContext gc = Controller.getGraphicsContext();
		Controller.doOnCanvasClick(new ClickOperation(CursorMode.DOTS, click -> {
			// Make sure you get the height and width in here if you're expecting them to change!
			int width = Controller.getCursorWidth();
			int height = Controller.getCursorHeight();
			gc.fillOval(click.x, click.y, width, height); // x2 to make rectangles bigger, for demonstration
		}));

		Stub s = new Stub();
		s.example();
	}
}