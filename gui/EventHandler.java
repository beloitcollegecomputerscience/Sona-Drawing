package gui;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

import gui.GUI.CursorMode;
import gui.GUI.GUIState;
import helperClasses.ClickOperation;
import helperClasses.Point;
import helperClasses.Setter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class EventHandler implements Initializable {

	private static Vector<ClickOperation> canvasOperations = new Vector<>();
	
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
	RadioMenuItem viewModeButton;
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
				for (ClickOperation d : canvasOperations)
					d.execute(getLastClick((MouseEvent) e));
			}
		});
	}

	private static void handleSlider(Slider s, MenuItem label, Setter<Integer> setter) {
		// Update actual value only when user is done sliding
		s.addEventHandler(MouseEvent.MOUSE_RELEASED, (event) -> {
			setter.set(((int) s.getValue()));
		});
		// Don't forget to continuously update the label!
		s.valueProperty().addListener((event) -> {
			label.setText(Integer.toString((int) s.getValue()));
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GUI.setGraphicsContext(canvas.getGraphicsContext2D());
		handleSlider(heightSlider, heightLabel, (val) -> {
			GUI.setCanvasHeight(val);
		});
		handleSlider(widthSlider, widthLabel, (val) -> {
			GUI.setCanvasWidth(val);
		});
		handleMenu(guiModes, GUI.GUIState.values(), (mode) -> {
			GUI.setGuiState(mode);
		});
		handleMenu(toolsMenu, GUI.CursorMode.values(), (mode) -> {
			GUI.setCursorMode(mode);
		});
		handleCanvas(canvas);
	}
	private <T> void handleMenu(Menu menu, T[] modes, Setter<T> modeSet) {
		Iterator<MenuItem> iter = menu.getItems().iterator();
		for (T mode : modes) {
			iter.next().setOnAction((event) -> {
				modeSet.set(mode);
			});
		}
	}
}
