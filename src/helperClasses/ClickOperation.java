package helperClasses;

import controller.Controller.CursorMode;

public class ClickOperation implements Operation<Point> {

	private Operation<Point> operation;
	private CursorMode mode = null;

	public ClickOperation(CursorMode mode, Operation<Point> o) {
		this.mode = mode;
		this.operation = o;
	}

	public ClickOperation(Operation<Point> o) {
		this.operation = o;
	}

	@Override
	public void execute(Point click) {
		operation.execute(click);
	}

	public CursorMode getMode() {
		return mode;
	}
}