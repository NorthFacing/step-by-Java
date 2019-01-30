package com.adolphor.thenewboston.tutor11_CheckBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
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
    window.setTitle("Checkbox example");

    button = new Button("Order now");

    CheckBox box1 = new CheckBox("Bacon");
    CheckBox box2 = new CheckBox("Tuna");
    box2.setSelected(true);

    button.setOnAction(e -> handleOptions(box1, box2));

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(box1, box2, button);

    scene = new Scene(layout, 300, 200);
    window.setScene(scene);
    window.show();

  }

  private void handleOptions(CheckBox box1, CheckBox box2) {

    String message = "User options is : \n";
    if (box1.isSelected()) {
      message += box1.getText() + "\n";
    }
    if (box2.isSelected()) {
      message += box2.getText() + "\n";
    }
    System.out.println(message);
  }

}
