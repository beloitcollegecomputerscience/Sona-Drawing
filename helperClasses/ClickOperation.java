package helperClasses;

import gui.Controller;
import gui.Controller.CursorMode;

public class ClickOperation implements Operation<Point> {

	private Operation<Point> operation;
	private CursorMode mode;

	public ClickOperation(CursorMode mode, Operation<Point> o) {
		this.mode = mode;
		this.operation = o;
	}
	public ClickOperation(Operation<Point> o) {
		this.operation = o;
	}

	@Override
	public void execute(Point click) {
		if (Controller.getMode() == mode || mode == null)
			operation.execute(click);
	}
}