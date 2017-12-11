package com.adolphor.tutor03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		button = new Button("Clike me");
		button.setOnAction(e-> System.out.println("Don't touch the button anymore, plz....."));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout,300,200);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

}