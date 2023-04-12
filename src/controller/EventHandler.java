package controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Controller.CursorMode;
import helperClasses.Point;
import helperClasses.SonaSlider;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EventHandler implements Initializable {

	@FXML
	Canvas canvas;
	@FXML
	ToggleButton dotsButton;
	@FXML
	ToggleButton wallsButton;
	@FXML
	ToggleButton linesButton;
	@FXML
	ToggleButton viewButton;
	@FXML
	Button clearButton;
	@FXML
	Text heightLabel;
	@FXML
	Slider heightSlider;
	@FXML
	Text widthLabel;
	@FXML
	Slider widthSlider;

	private static void doCanvasClickOperations(Point click) {
		CanvasHandler.executeAll(click);
	}

	private static Point getClick(MouseEvent e) {
		return new Point((int) e.getX(), (int) e.getY());
	}

	private static void handleCanvas(Canvas c) {
		c.addEventHandler(Event.ANY, (e) -> {
			if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				Point click = getClick((MouseEvent) e);
				doCanvasClickOperations(click);
			}
		});
	}

	private static void handleToggleButton(ToggleButton b, CursorMode m) {
		b.setOnAction((e) -> {
			Controller.setMode(m);
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CanvasHandler.init();
		Controller.init(canvas);
		handleCanvas(canvas);
		handleModeSetting();
		initSliders();
		Controller.update();
	}

	private void handleModeSetting() {
		handleToggleButton(dotsButton, CursorMode.DOTS);
		handleToggleButton(wallsButton, CursorMode.WALLS);
		handleToggleButton(linesButton, CursorMode.LINES);
		handleToggleButton(viewButton, CursorMode.VIEW);
	}

	private void initSliders() {
		SonaSlider height = new SonaSlider(heightSlider, "Height: ", heightLabel);
		SonaSlider width = new SonaSlider(widthSlider, "Width: ", widthLabel);
		Controller.setSliders(height, width);
	}

}
