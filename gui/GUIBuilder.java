package gui;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
		ChoiceBox<String> mode = new ChoiceBox<>();
		String[] drawmode = {"Draw", "View"};
		mode.getItems().addAll(drawmode);
		Button dotButton = new Button("Dot");
		HBox tools = new HBox(TOOLBARSIZE);
		tools.getChildren().add(mode);
		tools.getChildren().add(dotButton);
		tools.setStyle(TOOLBARSTYLE);
		return tools;
	}
}
