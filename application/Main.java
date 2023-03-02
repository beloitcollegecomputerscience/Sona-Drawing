package application;

import gui.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static GUI gui = GUI.getInstance();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		gui.showWindow(stage);
	}
}