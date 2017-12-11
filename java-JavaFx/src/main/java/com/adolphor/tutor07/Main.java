package com.adolphor.tutor07;

import com.adolphor.tutor06.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("the new boston");

		window.setOnCloseRequest(e -> {
			e.consume(); // TODO 作用？
			closeProgram();
		});

		button = new Button("Click me");
		button.setOnAction(e -> {
			closeProgram();
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 300, 200);
		window.setScene(scene);

		window.show();
	}

	private void closeProgram() {
		boolean result = ConfirmBox.display("Title", "Sure you want to exit?");
		if (result) {
			window.close();
		}
	}

}
