package application;

import gui.Controller;
import gui.GUI;
import gui.Controller.CursorMode;
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

		//Example code
		GraphicsContext gc = Controller.getGraphicsContext();
		Controller.doOnCanvasClick(new ClickOperation(CursorMode.DOTS, click -> {
			// Make sure you get the height and width in here if you're expecting them to change!
			int width = Controller.getCursorWidth();
			int height = Controller.getCursorHeight();
			gc.fillRect(click.x, click.y, width * 2, height * 2); // x2 for demonstration
		}));

		Stub s = new Stub();
		s.example();
	}
}