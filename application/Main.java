package application;

import gui.GUI;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

	private static GUI gui = GUI.getInstance();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		gui.showWindow(stage);
		GraphicsContext gc = GUI.getGraphicsContext();
		GUI.doOnCanvasClick(() -> {
			Point2D p = GUI.getLastClick();
			if (GUI.getGuiState().equals(GUI.GUIState.DRAW)) {
				gc.fillRect(p.getX(), p.getY(), 10, 10);
			} else {
				gc.fillOval(p.getX(), p.getY(), 20, 20);
			}
		});
	}
}