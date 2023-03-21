package application;

import gui.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GUI.getInstance().showWindow(stage);

		// Example: a grid of squares that appear on click, specific numbers not important
		final int padding = 2;
		final int boxSize = 18;
		final int boxesX = 40;
		final int boxesY = 30;
		DummyRectangle[][] grid = new DummyRectangle[boxesY][boxesX];
		for (int j = 0; j < boxesY; j++) {
			for (int i = 0; i < boxesX; i++) {
				grid[j][i] = new DummyRectangle(i * (boxSize + padding), j * (boxSize + padding), boxSize);
				grid[j][i].drawOnClick();
			}
		}
	}
}