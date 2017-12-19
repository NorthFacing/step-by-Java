package com.adolphor.thenewboston.tutor30_binding_example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("binding example");

		TextField input = new TextField();
		input.setMaxWidth(300);

		Label firstLabel = new Label("Welcome to site ");
		Label secondLabel = new Label();

		// 注意:
		// 是 textProperty 而不是 getProperties
		// 是 bind 而不是 addListener
		secondLabel.textProperty().bind(input.textProperty());

		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(firstLabel, secondLabel);

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(input, hBox);

		scene = new Scene(layout, 500, 300);
		window.setScene(scene);
		window.show();
	}
}
