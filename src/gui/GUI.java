package gui;

import java.io.FileInputStream;
import java.io.IOException;

import helperClasses.SliderOperation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUI {

	protected static enum GUIState { // order is important
		DOTS, WALLS, LINE, VIEW;
	}
	private static final String FXMLURL = "src/gui/gui.fxml";
	private static GUI instance = null;
	private static final boolean RESIZEABLE = false;
	private static Scene root;

	private GUI() { // ran only once
		try {
			root = new Scene(readFXML());
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
