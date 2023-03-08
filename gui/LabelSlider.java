package gui;

import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public abstract class LabelSlider {
	public static void init(Slider s, MenuItem label, Setter<Integer> setter) {
		// Update actual value only when user is done sliding
		s.addEventHandler(MouseEvent.MOUSE_RELEASED, (event) -> {
			setter.set(((int) s.getValue()));
		});
		//Don't forget to continuously update the label!
		s.valueProperty().addListener((event) -> {
			label.setText(Integer.toString((int) s.getValue()));
		});
	}
}
