package gui;

import java.util.Vector;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class CanvasHandler implements EventHandler<Event> {

	private static Vector<DrawOperation> drawOperations = new Vector<>();

	@Override
	public void handle(Event e) {
		if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			GUI.setLastClick(new Point2D(((MouseEvent) e).getX(), ((MouseEvent) e).getY()));
			for (DrawOperation d : drawOperations)
				d.draw();
		}
	}
	
	public static void addDrawOperation(DrawOperation d) {
		drawOperations.add(d);
	}
}