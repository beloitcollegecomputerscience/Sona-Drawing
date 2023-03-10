package gui;

import java.io.FileInputStream;
import java.io.IOException;

import helperClasses.ClickOperation;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUI {

	protected static enum CursorMode { // order is important
		EIGHT, ELEVEN, FIVE, FOUR, NINE, ONE, SEVEN, SIX, TEN, THREE, TWO, ZERO;
	}
	protected static enum GUIState { // order is important
		DRAW, VIEW;
	}
	private static int canvasHeight = 5;
	private static int canvasWidth = 5;

	private static CursorMode cursorMode = CursorMode.ZERO;
	private static GraphicsContext gc;
	private static GUIState guiState = GUIState.VIEW;
	private static GUI instance = null;
	private static Point2D lastClick;
	private static FXMLLoader loader = new FXMLLoader();
	private static final boolean RESIZEABLE = false;
	private static Scene root;

	private GUI() { // ran only once
		try {
			Parent root = loader.load(new FileInputStream("gui/gui.fxml"));
			setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public static void doOnCanvasClick(ClickOperation b) {
		EventHandler.addCanvasOperation(b);
	}

	public static int getCanvasHeight() {
		return canvasHeight;
	}
	public static int getCanvasWidth() {
		return canvasWidth;
	}
	public static CursorMode getCursorMode() {
		return cursorMode;
	}

	public static GraphicsContext getGraphicsContext() {
		return gc;
	}

	public static GUIState getGuiState() {
		return guiState;
	}

	public static GUI getInstance() {
		if (instance == null) {
			instance = new GUI();
		}
		return instance;
	}

	public static Point2D getLastClick() {
		return lastClick;
	}

	public static void setScene(Scene root) {
		GUI.root = root;
	}

	protected static void setCanvasHeight(int canvasHeight) {
		GUI.canvasHeight = canvasHeight;
	}

	protected static void setCanvasWidth(int canvasWidth) {
		GUI.canvasWidth = canvasWidth;
	}

	protected static void setCursorMode(CursorMode cursorMode) {
		GUI.cursorMode = cursorMode;
	}

	protected static void setGraphicsContext(GraphicsContext gc) {
		GUI.gc = gc;
	}

	protected static void setGuiState(GUIState guiState) {
		GUI.guiState = guiState;
	}

	protected static void setLastClick(Point2D mousePos) {
		GUI.lastClick = mousePos;
	}

	protected static void setState(GUIState gUIState) {
		GUI.setGuiState(gUIState);
	}

	public void showWindow(Stage stage) { // cannot be static
		stage.setScene(root);
		stage.setTitle("Sona Drawing");
		stage.setResizable(RESIZEABLE);
		stage.show();
	}
}
