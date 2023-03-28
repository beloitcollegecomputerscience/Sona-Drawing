package helperClasses;

@FunctionalInterface
public interface Operation<T> {
	public void execute(T t);
}
