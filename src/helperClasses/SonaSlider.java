package helperClasses;

import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SonaSlider {

	private String prefix;
	private SliderOperation o = val -> {
	};
	private Text label;
	private Slider slider;
	private int value = 5;

	public SonaSlider(Slider slider, String prefix, Text label) {
		this.slider = slider;
		this.prefix = prefix;
		this.label = label;
	}

	public Slider getSlider() {
		return slider;
	}

	public void setBehavior(SliderOperation o) {
		this.o = o;
	}

	public void update() {
		doSliderBehavior();
		updateLabel();
	}

	private void doSliderBehavior() {
		// Update actual value only when user is done sliding
		slider.addEventHandler(MouseEvent.MOUSE_RELEASED, (e) -> {
			value = (int) slider.getValue();
			o.execute(value);
		});
	}

	private String getPadding(int value) {
		if (value < 10) {
			return " ";
		}
		return "";
	}

	private void updateLabel() {
		slider.valueProperty().addListener((e) -> {
			int value = (int) slider.getValue();
			label.setText(prefix + value + getPadding(value));
		});
	}

	public int getValue() {
		return value;
	}
}
