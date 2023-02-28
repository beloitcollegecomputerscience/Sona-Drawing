package application;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class Main extends Application {

	private Canvas canvas; // The drawing area where the user draws.

	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		canvas = makeCanvas();
		StackPane canvasHolder = new StackPane(canvas);
		canvasHolder.setStyle("-fx-border-width: 1px; -fx-border-color: blue");
		BorderPane root = new BorderPane(canvasHolder);
		root.setStyle("-fx-border-width: 1px; -fx-border-color: black");
		root.setBottom(makeToolPanel(canvas));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Sona Drawing");
		stage.setResizable(false);
		stage.show();
	}

	private Canvas makeCanvas() { //Drawing pane
		Canvas canvas = new Canvas(500, 500);
		return canvas;
	}

	private HBox makeToolPanel(Canvas canvas) {
		Button dotButton = new Button("Dot");    
		HBox tools = new HBox(10);
		tools.getChildren().add(dotButton);
		tools.setStyle("-fx-border-width: 5px; -fx-padding: 5; -fx-border-color: transparent; -fx-background-color: lightgray");
		return tools;
	}

}