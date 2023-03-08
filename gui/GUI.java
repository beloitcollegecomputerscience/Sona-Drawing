package gui;

import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUI {

	public static enum GUIState { //order is important
		VIEW, DRAW;
	}
	public static enum CursorMode { //order is important
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN;
	}
	private static GUIState guiState = GUIState.VIEW;
	private static CursorMode cursorMode = CursorMode.ZERO;

	private static GUI instance = null;
	private static Scene scene;
	private static int canvasHeight;
	private static int canvasWidth;
	private static Point2D lastClick;
	private static GraphicsContext gfx;

	private GUI() {
		// ran only once
	}
	public static GUI getInstance() {
		if (instance == null) {
			instance = new GUI();
			GUIBuilder.Build();
		}
		return instance;
	}

	public static CursorMode getCursorMode() {
		return cursorMode;
	}
	public static void setCursorMode(CursorMode cursorMode) {
		GUI.cursorMode = cursorMode;
	}
	public static int getCanvasHeight() {
		return canvasHeight;
	}

	public static int getCanvasWidth() {
		return canvasWidth;
	}

	public static Point2D getLastClick() {
		return lastClick;
	}

	protected static void setCanvasHeight(int canvasHeight) {
		GUI.canvasHeight = canvasHeight;
	}

	protected static void setCanvasWidth(int canvasWidth) {
		GUI.canvasWidth = canvasWidth;
	}

	protected static void setLastClick(Point2D mousePos) {
		GUI.lastClick = mousePos;
	}

	public static void setScene(Scene scene) {
		GUI.scene = scene;
	}

	protected static void setState(GUIState gUIState) {
		GUI.setGuiState(gUIState);
	}

	public void showWindow(Stage stage) { // cannot be static
		stage.setScene(scene);
		stage.setTitle("Sona Drawing");
		stage.setResizable(true);
		stage.show();
	}

	public static GUIState getGuiState() {
		return guiState;
	}

	public static void setGuiState(GUIState guiState) {
		GUI.guiState = guiState;
	}

	public static GraphicsContext getGraphicsContext() {
		return gfx;
	}

	public static void doOnCanvasClick(Operation b) {
		EventHandler.addCanvasOperation(b);
	}

	protected static void setGraphicsContext(GraphicsContext gfx) {
		GUI.gfx = gfx;
	}
}
