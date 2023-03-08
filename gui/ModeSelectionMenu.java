package gui;

import java.util.Iterator;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public abstract class ModeSelectionMenu {
	public static <T> void init(Menu m, T[] modes, Setter<T> modeSet) {
		Iterator<MenuItem> iter = m.getItems().iterator();
		for (T mode : modes) {
			System.out.println(mode);
			iter.next().setOnAction((event) -> {
				modeSet.set(mode);
			});
		}
	}
}
