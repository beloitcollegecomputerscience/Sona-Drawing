package gui;

import java.util.Vector;
import helperClasses.ClickOperation;
import helperClasses.SliderOperation;
import helperClasses.SonaSlider;
import javafx.scene.canvas.GraphicsContext;

public class Controller {

	public static enum CursorMode {
		DOTS, LINES, WALLS, VIEW;
	}
	private static CursorMode cursorMode = CursorMode.DOTS; // Default
	private static SonaSlider heightSlider;
	private static SonaSlider widthSlider;
	private static Vector<ClickOperation> canvasOperations = new Vector<>();
	public static Controller instance = null;
	private static GraphicsContext gc;

	private Controller() {
	};

	public static void doOnCanvasClick(ClickOperation o) {
		canvasOperations.add(o);
	}

	public static void doOnHeightUpdate(SliderOperation o) {
		heightSlider.setBehavior(o);
	}

	public static void doOnWidthUpdate(SliderOperation o) {
		widthSlider.setBehavior(o);
	}

	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
		return instance;
	}

	protected static Vector<ClickOperation> getCanvasOperations() {
		return canvasOperations;
	}

	protected static void setMode(Controller.CursorMode cursorMode) {
		Controller.cursorMode = cursorMode;
	}

	public static CursorMode getMode() {
		return cursorMode;
	}

	protected static void setSliders(SonaSlider height, SonaSlider width) {
		heightSlider = height;
		widthSlider = width;
	}

	protected static void update() {
		updateSliders();
	}

	protected static void updateSliders() {
		heightSlider.update();
		widthSlider.update();
	}

	public static int getCursorWidth() {
		return widthSlider.getValue();
	}
	public static int getCursorHeight() {
		return heightSlider.getValue();
	}

	public static void setGraphicsContext(GraphicsContext gc) {
		Controller.gc = gc;
	}

	public static GraphicsContext getGraphicsContext() {
		return gc;
	}
}
