package gui;

import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI {

	public enum GUIState {
		DRAW, VIEW;
	}
	public enum CursorMode {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN;
	}
	public GUIState guiState = GUIState.VIEW;
	public CursorMode cursorMode = CursorMode.ZERO;

	private static GUI instance = null;
	public static GUI instanceOf() {
		if (instance == null)
			instance = GUIBuilder.Build(new GUI()); // this one
		return instance;
	}
	
	private Scene scene;
	private int canvasHeight;
	private int canvasWidth;
	private Point2D lastClick;

	private GUI() {
		// ran only once
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public Point2D getLastClick() {
		return lastClick;
	}

	public GUIState guiMode() {
		return guiState;
	}

	protected void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	protected void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public void setLastClick(Point2D mousePos) {
		this.lastClick = mousePos;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	protected void setState(GUIState gUIState) {
		this.guiState = gUIState;
	}

	public void showWindow(Stage stage) {
		stage.setScene(scene);
		stage.setTitle("Sona Drawing");
		stage.setResizable(true);
		stage.show();
	}
}
