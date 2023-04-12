package application;
import controller.Controller;
import controller.Controller.CursorMode;
import helperClasses.ClickOperation;
import helperClasses.Point;

public class Stub {
	// Example code for doing stuff on click
	public void example() {
		// Interfacing with the GUI
		Controller.doOnCanvasClick(new ClickOperation(click -> {
			// 'click' is the x,y location of the last mouse click (you can call it anything you want)
			// Code to execute below
			System.out.println("Click! x:" + click.x + " y:" + click.y);
		}));;
	}
}
