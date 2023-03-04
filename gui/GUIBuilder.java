package gui;


import java.awt.MenuBar;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;

public abstract class GUIBuilder {

	private static final int TOOLBARSIZE = 10;
	private static final int[] CANVASSIZE = { 500, 500 };
	private static final String STACKPANESTYLE = "-fx-border-width: 1px; -fx-border-color: blue";
	private static final String BORDERPANESTYLE = "-fx-border-width: 1px; -fx-border-color: black";
	private static final String TOOLBARSTYLE = "-fx-border-width: 5px; -fx-padding: 5; -fx-border-color: transparent; -fx-background-color: lightgray";
	
	protected static GUI Build(GUI gui) {
		Canvas canvas = makeCanvas();
		Scene scene = makeScene(canvas);
		gui.setCanvas(canvas);
		gui.setScene(scene);
		return gui;
	}

	private static Canvas makeCanvas() { // Drawing pane
		return new Canvas(CANVASSIZE[0], CANVASSIZE[1]);
	}

	private static StackPane makeStackPane(Canvas c) {
		StackPane s = new StackPane(c);
		s.setStyle(STACKPANESTYLE);
		return s;
	}

	private static BorderPane makeBorderPane(Canvas c) {
		StackPane s = makeStackPane(c);
		BorderPane root = new BorderPane(s);
		root.setStyle(BORDERPANESTYLE);
		root.setBottom(makeToolPanel(c));
		return root;
	}

	private static Scene makeScene(Canvas c) {
		return new Scene(makeBorderPane(c));
	}

	private static HBox makeToolPanel(Canvas canvas) {
		Button dotButton = new Button("Dot");
		Button rectButton = new Button("Add Rectangle");
		
		ChoiceBox<String> height = makeChoiceBox();
		height.setValue("20");
		ChoiceBox<String> width = makeChoiceBox();
		width.setValue("20");

		HBox tools = new HBox(TOOLBARSIZE);
		tools.getChildren().add(height);
		tools.getChildren().add(width);
		tools.getChildren().add(dotButton);
		tools.getChildren().add(rectButton);
		tools.setStyle(TOOLBARSTYLE);
		return tools;
	}
	
	private static ChoiceBox<String> makeChoiceBox() {
		ChoiceBox<String> height = new ChoiceBox<>();
		String[] heightNums = new String[20];
		for (int i = 0; i < 20; i++) {
			heightNums[i] = Integer.toString(i+1);
		}
		height.getItems().addAll(heightNums);
		return height;
	}

}
