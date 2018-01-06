package com.adolphor.bob.treeViewObject;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Tree tree = new Tree(createAccounts());
    TreeView<GameObject<?>> treeView = tree.getTreeView();

    TextField addField = new TextField();
    Button addButton = new Button("Add");
    EventHandler<ActionEvent> addHandler = e -> {
      TreeItem<GameObject<?>> selected = treeView
          .getSelectionModel()
          .getSelectedItem();
      if (selected != null) {
        selected.getValue().createAndAddChild(addField.getText());
        addField.clear();
      }
    };
    addField.setOnAction(addHandler);
    addButton.setOnAction(addHandler);
    addButton.disableProperty().bind(Bindings.createBooleanBinding(() -> {
      TreeItem<GameObject<?>> selected = treeView.getSelectionModel().getSelectedItem();
      return selected == null || selected.getValue() instanceof Information;
    }, treeView.getSelectionModel().selectedItemProperty()));

    Button deleteButton = new Button("Delete");
    deleteButton.setOnAction(e -> {
      TreeItem<GameObject<?>> selected = treeView.getSelectionModel().getSelectedItem();
      TreeItem<GameObject<?>> parent = selected.getParent();
      parent.getValue().getItems().remove(selected.getValue());
    });
    deleteButton.disableProperty().bind(treeView.getSelectionModel().selectedItemProperty().isNull());

    HBox controls = new HBox(5, addField, addButton, deleteButton);
    controls.setPadding(new Insets(5));
    controls.setAlignment(Pos.CENTER);

    BorderPane root = new BorderPane(treeView);
    root.setBottom(controls);

    Scene scene = new Scene(root, 600, 600);
//    scene.getStylesheets().add(getClass().getResource("/ui/style/style.css").toExternalForm());
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private ObservableList<Account> createAccounts() {
    Account jake = new Account("Jake");
    Account mark = new Account("Mark");
    Account freshAcc = new Account("Fresh Account");
    Account marksAltAcc = new Account("Mark's alternative account");
    Account jeffrey = new Account("Jeffrey");

    GameCharacter jakesChar = new GameCharacter("Jakes character");
    Item amazingSword = new Item("Amazing Sword");
    Item brokenBow = new Item("Broken Bow");
    Item junkMetal = new Item("Junk Metal");

    GameCharacter myChar = new GameCharacter("Me");
    Item godlyAxe = new Item("Godly Axe");

    GameCharacter level = new GameCharacter("I'll level this I promise");

    GameCharacter jeff = new GameCharacter("Jeff");
    Item superGun = new Item("Super Gun");
    Item superGunScope = new Item("Super Gun Scope");

    jake.getItems().add(jakesChar);
    mark.getItems().add(myChar);
    marksAltAcc.getItems().add(level);
    jeffrey.getItems().add(jeff);

    jakesChar.getItems().addAll(amazingSword, brokenBow, junkMetal);
    myChar.getItems().add(godlyAxe);
    jeff.getItems().addAll(superGun, superGunScope);

    return FXCollections.observableArrayList(jake, mark, freshAcc, marksAltAcc, jeffrey);

  }

}