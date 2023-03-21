package gui;

import java.io.FileInputStream;
import java.io.IOException;

import helperClasses.ClickOperation;
import helperClasses.SliderOperation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUI {

	protected static enum CursorMode { // order is important
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN;
	}
	protected static enum GUIState { // order is important
		DOT, DRAW;
	}
	private static int canvasHeight = 5;
	private static int canvasWidth = 5;

	private static CursorMode cursorMode = CursorMode.ZERO;
	private static final String FXMLURL = "gui/gui.fxml";
	private static GraphicsContext gc;
	private static GUIState guiState = GUIState.DOT;
	private static GUI instance = null;
	private static final boolean RESIZEABLE = false;
	private static Scene root;

	private GUI() { // ran only once
		try {
			root = new Scene(readFXML());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void doOnCanvasClick(ClickOperation o) {
		EventHandler.addCanvasOperation(o);
	}

	public static void doOnHeightUpdate(SliderOperation o) {
		EventHandler.addHeightUpdateOperation(o);
	}

	public static void doOnWidthUpdate(SliderOperation o) {
		EventHandler.addWidthUpdateOperation(o);
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
		if (instance == null)
			instance = new GUI();
		return instance;
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

	private static Parent readFXML() throws IOException {
		FileInputStream fs = new FileInputStream(FXMLURL);
		FXMLLoader fxmlLoader = new FXMLLoader();
		return fxmlLoader.load(fs);
	}

	public void showWindow(Stage stage) { // cannot be static
		stage.setScene(root);
		stage.setTitle("Sona Drawing");
		stage.setResizable(RESIZEABLE);
		stage.show();
	}
}
