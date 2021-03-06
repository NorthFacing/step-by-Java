package com.adolphor.thenewboston.tutor09;

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
  public void start(Stage primaryStage) {

    window = primaryStage;
    window.setTitle("the new boston");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(8); // 横间距
    grid.setHgap(10); // 竖间距

    Label nameLabel = new Label("UserName");
    GridPane.setConstraints(nameLabel, 0, 0);

    TextField nameInput = new TextField("Bucky");
    GridPane.setConstraints(nameInput, 1, 0);

    Label passLabel = new Label("Password");
    GridPane.setConstraints(passLabel, 0, 1);

    TextField passInput = new TextField();
    passInput.setPromptText("password"); // prompt文本（点击消失）
    GridPane.setConstraints(passInput, 1, 1);

    Button loginButton = new Button("Log In");
    GridPane.setConstraints(loginButton, 1, 2);

    // 这些元素在什么时候会换行？
    grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

    window.setScene(new Scene(grid, 300, 200));

    window.show();
  }

}
