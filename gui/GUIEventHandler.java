package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
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
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Point2D lastClick = new Point2D(e.getX(), e.getY());
				GUI.instanceOf().setLastClick(lastClick);
				GUI.instanceOf().setGraphicsContext(canvas.getGraphicsContext2D());
				GUI.instanceOf().drawRect(new Rectangle(lastClick.getX(), lastClick.getY(), 10, 10));
			}
		});
	}
	public void readViewButton() {
		GUI.instanceOf().setState(GUI.State.VIEW);
	}
	public void readDrawButton() {
		GUI.instanceOf().setState(GUI.State.DRAW);
	}
}
