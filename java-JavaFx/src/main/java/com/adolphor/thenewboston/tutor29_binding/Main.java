package com.adolphor.thenewboston.tutor29_binding;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    window.setTitle("example");

    IntegerProperty x = new SimpleIntegerProperty(3);
    IntegerProperty y = new SimpleIntegerProperty();

    y.bind(x.multiply(10));
    System.out.println("x = " + x.getValue());
    System.out.println("y = " + y.getValue());

    x.setValue(9);
    System.out.println("x = " + x.getValue());
    System.out.println("y = " + y.getValue());


    button = new Button("Click me");

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(button);

    scene = new Scene(layout, 500, 300);
    window.setScene(scene);
    window.show();
  }
}
