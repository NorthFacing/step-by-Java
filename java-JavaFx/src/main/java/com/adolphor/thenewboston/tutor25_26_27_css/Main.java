package com.adolphor.thenewboston.tutor25_26_27_css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("CSS example");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); // 横间距
		grid.setHgap(10); // 竖间距

		Label nameLabel = new Label("UserName");
//		nameLabel.setStyle("-fx-text-fill: #e8e8e8");
		nameLabel.setId("bold-label"); // 根据节点ID进行样式调整
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);

		Label passLabel = new Label("Password");
//		passLabel.setStyle("-fx-text-fill: #e8e8e8");
		GridPane.setConstraints(passLabel, 0, 1);

		TextField passInput = new TextField();
		passInput.setPromptText("password"); // prompt文本（点击消失）
		GridPane.setConstraints(passInput, 1, 1);

		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);

		Button signUpBtn = new Button("Sign Up");
		signUpBtn.getStyleClass().add("button-blue"); // 添加自定义样式
		GridPane.setConstraints(signUpBtn, 1, 3);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpBtn);

		Scene scene = new Scene(grid, 300, 200);
		scene.getStylesheets().addAll("tutor25_viper.css");

		window.setScene(scene);
		window.show();
	}
}
