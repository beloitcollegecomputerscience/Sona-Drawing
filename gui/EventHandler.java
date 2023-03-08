package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GUI.setGraphicsContext(canvas.getGraphicsContext2D());
		LabelSlider.init(heightSlider, heightLabel, (h) -> {
			GUI.setCanvasWidth(h);
		});
		LabelSlider.init(widthSlider, widthLabel, (w) -> {
			GUI.setCanvasWidth(w);
		});
		ModeSelectionMenu.init(guiModes, GUI.GUIState.values(), (m) -> {
			GUI.setGuiState(m);
		});
		ModeSelectionMenu.init(toolsMenu, GUI.CursorMode.values(), (m) -> {
			GUI.setCursorMode(m);
		});
		canvas.addEventHandler(Event.ANY, new CanvasHandler());
	}
}
