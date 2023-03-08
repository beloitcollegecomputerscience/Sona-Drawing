package gui;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class EventHandler implements Initializable {

	@FXML
	Slider heightSlider;
	@FXML
	Slider widthSlider;
	@FXML
	MenuItem heightLabel;
	@FXML
	MenuItem widthLabel;
	@FXML
	RadioMenuItem viewModeButton;
	@FXML
	RadioMenuItem drawModeButton;
	@FXML
	Canvas canvas;
	@FXML
	Menu toolsMenu;
	@FXML
	Menu guiModes;

	private static Vector<Operation> canvasOperations = new Vector<>();

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

	private static void handleCanvas(Canvas c) {
		c.addEventHandler(Event.ANY, (event) -> {
			if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				GUI.setLastClick(new Point2D(((MouseEvent) event).getX(), ((MouseEvent) event).getY()));
				for (Operation d : canvasOperations)
					d.execute();
			}
		});
	}
	
	public static void addCanvasOperation(Operation d) {
		canvasOperations.add(d);
	}
}
