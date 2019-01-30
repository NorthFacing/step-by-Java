package com.adolphor.thenewboston.tutor16_TreeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  TreeView<String> tree;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("example");

    TreeItem<String> root = new TreeItem<>();
    root.setExpanded(true);

    // branch A
    TreeItem<String> branch_A = makeBranch("Branch-A", root);
    makeBranch("A1", branch_A);
    makeBranch("A2", branch_A);
    makeBranch("A3", branch_A);

    // branch B
    TreeItem<String> branch_B = makeBranch("Branch-B", root);
    makeBranch("B1", branch_B);
    makeBranch("B2", branch_B);

    tree = new TreeView<>(root);
    tree.setShowRoot(false);
    tree.getSelectionModel().selectedItemProperty()
        .addListener((v, oldValue, newValue) -> {
          if (newValue != null)
            System.out.println(newValue.getValue());
        });

    StackPane layout = new StackPane();
    layout.getChildren().add(tree);
    Scene scene = new Scene(layout, 500, 300);
    window.setScene(scene);
    window.show();
  }

  private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
    TreeItem<String> treeItem = new TreeItem<>(title);
    treeItem.setExpanded(true);
    parent.getChildren().add(treeItem);
    return treeItem;
  }

}
