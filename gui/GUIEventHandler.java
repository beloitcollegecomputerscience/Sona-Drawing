package gui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class GUIEventHandler implements Initializable {
	
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
	
	HashMap<String, RadioMenuItem> toolButtons = new HashMap<>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (MenuItem b : toolsMenu.getItems()) {
			toolButtons.put(b.getId(), (RadioMenuItem)b);
		}
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//		System.out.println(gc);
//		System.out.println(GUI.instanceOf().getGraphicsContext());
//		DrawToCanvas.setCanvas(canvas);
		
		heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				int height = (int) heightSlider.getValue();
				GUI.instanceOf().setCanvasHeight(height);
				heightLabel.setText(Integer.toString(height));
			}
		});
		widthSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				int width = (int) widthSlider.getValue();
				GUI.instanceOf().setCanvasWidth(width);
				widthLabel.setText(Integer.toString(width));
			}
		});
		SonaCanvas.initialize(canvas);
	}
	public void readViewButton() {
		GUI.instanceOf().setState(GUI.GUIState.VIEW);
	}
	public void readDrawButton() {
		GUI.instanceOf().setState(GUI.GUIState.DRAW);
	}
}
