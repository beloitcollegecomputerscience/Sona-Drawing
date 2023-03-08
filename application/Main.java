package application;

import gui.GUI;
import gui.GUI.CursorMode;
import gui.GUI.GUIState;
import gui.SonaCanvas;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

	public static GUI gui = GUI.instanceOf();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		gui.showWindow(stage);
		
		//Testing ability to draw outside of eventhandler
		GraphicsContext gc = SonaCanvas.getGraphicsContext();
		SonaCanvas.drawOnClick(() -> {
			Point2D p = gui.getLastClick();
			if (gui.guiState.equals(GUIState.VIEW)) {
				gc.fillRect(p.getX(), p.getY(), 10, 10);
			} else {
				gc.fillOval(p.getX(), p.getY(), 10, 10);
			}
		});
	}
}