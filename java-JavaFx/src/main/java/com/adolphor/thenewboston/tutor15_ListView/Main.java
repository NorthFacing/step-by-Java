package com.adolphor.thenewboston.tutor15_ListView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Scene scene;
  Button button;

  ListView<String> listView;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("ListView example");

    button = new Button("Click me");

    listView = new ListView<>();
    listView.getItems().addAll(
        "Iron man",
        "Titanic",
        "Contact",
        "Surrogates"
    );

    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // 设置单选还是多选

    button.setOnAction(e -> buttonClicked());

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(listView, button);

    scene = new Scene(layout, 500, 300);
    window.setScene(scene);
    window.show();
  }

  private void buttonClicked() {
    ObservableList<String> movies = listView.getSelectionModel().getSelectedItems();
    for (String m : movies) {
      System.out.println(m);
    }
  }

}
