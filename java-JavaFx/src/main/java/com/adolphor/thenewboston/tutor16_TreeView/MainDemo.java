package com.adolphor.thenewboston.tutor16_TreeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainDemo extends Application {

  Stage window;
  TreeView<Person> tree;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("example");

    TreeItem<Person> root = new TreeItem<>();
    root.setExpanded(true);

    // branch A
    TreeItem<Person> branch_A = makeBranch("Branch-A", root);
    makeBranch("A1", branch_A);
    makeBranch("A2", branch_A);
    makeBranch("A3", branch_A);

    // branch B
    TreeItem<Person> branch_B = makeBranch("Branch-B", root);
    makeBranch("B1", branch_B);
    makeBranch("B2", branch_B);

    tree = new TreeView<Person>(root);
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

  private TreeItem<Person> makeBranch(String title, TreeItem<Person> parent) {
    TreeItem<Person> treeItem = new TreeItem<Person>(new Person(title, 29));
    treeItem.setExpanded(true);
    parent.getChildren().add(treeItem);
    return treeItem;
  }

  class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }

}
