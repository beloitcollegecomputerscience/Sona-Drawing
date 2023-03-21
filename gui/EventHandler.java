package gui;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

import helperClasses.ClickOperation;
import helperClasses.KBOperation;
import helperClasses.Operation;
import helperClasses.Point;
import helperClasses.SliderOperation;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class EventHandler implements Initializable {

	private static Vector<ClickOperation> canvasOperations = new Vector<>();
	private static Vector<SliderOperation> heightSliderOperations = new Vector<>();
	private static Vector<SliderOperation> widthSliderOperations = new Vector<>();
	private static Vector<KBOperation> keyboardOperations = new Vector<>();

	@FXML
	Canvas canvas;
	@FXML
	RadioMenuItem drawModeButton;
	@FXML
	Menu guiModes;
	@FXML
	MenuItem heightLabel;
	@FXML
	Slider heightSlider;
	@FXML
	Menu toolsMenu;
	@FXML
	RadioMenuItem dotModeButton;
	@FXML
	MenuItem widthLabel;
	@FXML
	Slider widthSlider;

	public static void addCanvasOperation(ClickOperation d) {
		canvasOperations.add(d);
	}

	private static Point getLastClick(MouseEvent e) {
		return new Point((int) e.getX(), (int) e.getY());
	}

	private static void handleCanvas(Canvas c) {
		c.addEventHandler(Event.ANY, (e) -> {
			if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				for (ClickOperation o : canvasOperations)
					o.execute(getLastClick((MouseEvent) e));
			}
		});
	}

	private static void handleSlider(Slider s, MenuItem label, Vector<SliderOperation> ops) {
		// Update actual value only when user is done sliding
		s.addEventHandler(MouseEvent.MOUSE_RELEASED, (e) -> {
			for (SliderOperation o : ops)
				o.execute((int) s.getValue());
		});
		// Don't forget to continuously update the label!
		s.valueProperty().addListener((e) -> {
			label.setText(Integer.toString((int) s.getValue()));
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GUI.setGraphicsContext(canvas.getGraphicsContext2D());
		handleSlider(heightSlider, heightLabel, heightSliderOperations);
		handleSlider(widthSlider, widthLabel, widthSliderOperations);
		handleMenu(guiModes, GUI.GUIState.values(), (mode) -> {
			GUI.setGuiState(mode);
		});
		handleMenu(toolsMenu, GUI.CursorMode.values(), (mode) -> {
			GUI.setCursorMode(mode);
		});
		handleCanvas(canvas);
	}
	private <T> void handleMenu(Menu menu, T[] modes, Operation<T> modeSet) {
		Iterator<MenuItem> iter = menu.getItems().iterator();
		for (T mode : modes) {
			iter.next().setOnAction((e) -> {
				modeSet.execute(mode);
			});
		}
	}

	protected static void addHeightUpdateOperation(SliderOperation o) {
		heightSliderOperations.add(o);
	}

	protected static void addWidthUpdateOperation(SliderOperation o) {
		widthSliderOperations.add(o);
	}
}
