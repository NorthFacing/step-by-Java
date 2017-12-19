package com.adolphor.thenewboston.tutor28_Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("example");

		Person bucky = new Person();
		bucky.firstNameProperty().addListener((v, oldVal, newVal) -> {
			System.out.println("name changed to: " + newVal);
			System.out.println("firstNameProperty: " + bucky.firstNameProperty());
			System.out.println("getFirstName: " + bucky.getFirstName());
		});

		button = new Button("Click me");

		button.setOnAction(e -> bucky.setFirstName("Porky"));

		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);

		scene = new Scene(layout, 500, 300);
		window.setScene(scene);
		window.show();
	}
}
