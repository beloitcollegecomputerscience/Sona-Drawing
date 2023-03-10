package helperClasses;

@FunctionalInterface
public interface ClickOperation {
	public void execute(Point lastClick);
}
