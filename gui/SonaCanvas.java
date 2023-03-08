package gui;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class SonaCanvas extends Canvas {

	private static Canvas canvas;

	public static void initialize(Canvas canvas) {
		SonaCanvas.canvas = canvas;
	}

	public static void drawOnClick(Behavior b) {
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				GUI.instanceOf().setLastClick(new Point2D(e.getX(), e.getY()));
				b.execute();
			}
		});
	}
	public static GraphicsContext getGraphicsContext() {
		return canvas.getGraphicsContext2D();
	}
}
