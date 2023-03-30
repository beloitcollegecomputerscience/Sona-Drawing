package controller;

import java.util.ArrayList;

import controller.Controller.CursorMode;
import helperClasses.ClickOperation;
import helperClasses.Point;

public class CanvasHandler {
	
	private static final int MODES = CursorMode.values().length + 1; // +1 for "always run" mode (at the end)
	private static ArrayList<ArrayList<ClickOperation>> operations;

	public static void init() {
		operations = new ArrayList<ArrayList<ClickOperation>>(MODES);
		for (int i = 0; i < MODES; i++)
			operations.add(new ArrayList<ClickOperation>());
	}
	
	protected static void add(ClickOperation o) {
		if (o.getMode() == null)
			operations.get(MODES - 1).add(o);
		else
			operations.get(o.getMode().ordinal()).add(o);
	}

	protected static void executeAll(Point click) {
		executeDefault(click);
		executeWhen(Controller.getMode(), click);
	}

	protected static void executeDefault(Point click) {
		for (ClickOperation o : operations.get(MODES - 1))
			o.execute(click);
	}

	protected static void executeWhen(CursorMode currentMode, Point click) {
		for (ClickOperation o : operations.get(currentMode.ordinal()))
			o.execute(click);
	}
}
