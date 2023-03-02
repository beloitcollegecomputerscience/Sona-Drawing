package gui;

import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class GUI {

	private Scene scene;
	private Canvas canvas;
	private static GUI instance = null;

	private GUI() {
		// private so there's only one
	}

	public static GUI getInstance() {
		if (instance == null)
			instance = GUIBuilder.Build(new GUI()); //this one
		return instance;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void showWindow(Stage stage) {
		stage.setScene(scene);
		stage.setTitle("Sona Drawing");
		stage.setResizable(false);
		stage.show();
	}

}
