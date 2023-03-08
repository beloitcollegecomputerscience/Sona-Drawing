package gui;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class GUIBuilder {

	private static FXMLLoader loader = new FXMLLoader();

	protected static void Build() {
		Scene scene = makeScene();
		GUI.setScene(scene);
	}
	
	private static Scene makeScene() {
		 try {
			Parent root = loader.load(new FileInputStream("gui/gui.fxml"));
			return new Scene(root);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
}
