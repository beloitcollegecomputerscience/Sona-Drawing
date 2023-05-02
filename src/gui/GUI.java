package gui;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI {
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static final String FXMLURL = "src/gui/gui.fxml";
	private static GUI instance = null;
	private static final boolean RESIZEABLE = false;
	private static Scene root;

	private GUI() { // ran only once
		try {
			root = new Scene(readFXML(), WINDOW_WIDTH, WINDOW_HEIGHT);
			//TODO initialize canvas here, should be one line
			//initialize everything else within canvas
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static GUI getInstance() {
		if (instance == null)
			instance = new GUI();
		return instance;
	}

	private static Parent readFXML() throws IOException {
		FileInputStream fs = new FileInputStream(FXMLURL);
		FXMLLoader fxmlLoader = new FXMLLoader();
		return fxmlLoader.load(fs);
	}

	public void showWindow(Stage stage) { // cannot be static
		stage.setScene(root);
		stage.setTitle("Sona Drawing");
		stage.setResizable(RESIZEABLE);
		stage.show();
	}
}
