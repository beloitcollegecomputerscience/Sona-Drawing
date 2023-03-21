package application;
import gui.GUI;
import helperClasses.Point;
import javafx.scene.canvas.GraphicsContext;

public class DummyRectangle {

	private static GraphicsContext gc = GUI.getGraphicsContext();
	private int height;
	private int width;
	private int x;
	private int y;

	public DummyRectangle(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.width = size;
		this.height = size;
	}
	public DummyRectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	private static boolean numInRange(int lower, int p, int upper) {
		return (lower <= p && p <= upper);
	}

	public void drawOnClick() {
		GUI.doOnCanvasClick((click) -> {
			if (this.isClicked(click))
				gc.fillRect(x, y, width, height);
		});
	}

	// Example code for drawing (or doing anything on click)
	public void example() {
		// Interfacing with the GUI
		GUI.doOnCanvasClick((click) -> {
			// 'click' is the x,y location of the last mouse click (you can call it anything you want)
			// Code to execute below
			System.out.println("Click! x:" + click.x + " y:" + click.y);
		});
	}

	private boolean isClicked(Point click) {
		// Check if the click was within the bounds of this (dummy) rectangle.
		return (numInRange(x, click.x, x + width) && numInRange(y, click.y, y + height));
	}
}
