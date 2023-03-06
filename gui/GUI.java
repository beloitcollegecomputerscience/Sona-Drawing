package gui;

import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUI {

	enum State {
		DRAW, VIEW;
	}

	private static GUI instance = null;
	public static GUI instanceOf() {
		if (instance == null)
			instance = GUIBuilder.Build(new GUI()); // this one
		return instance;
	}
	private Scene scene;
	private int canvasHeight;
	private int canvasWidth;
	private Point2D mousePos;

	private State state = State.VIEW;
	private GraphicsContext graphics;

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
		return mousePos;
	}

	public State guiMode() {
		return state;
	}

	protected void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	protected void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public void setLastClick(Point2D mousePos) {
		this.mousePos = mousePos;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	protected void setState(State state) {
		this.state = state;
	}

	public void showWindow(Stage stage) {
		stage.setScene(scene);
		stage.setTitle("Sona Drawing");
		stage.setResizable(true);
		stage.show();
	}

	public void setGraphicsContext(GraphicsContext gc) {
		this.graphics = gc;
	}
}
