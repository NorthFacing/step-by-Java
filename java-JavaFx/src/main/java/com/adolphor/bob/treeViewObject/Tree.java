package com.adolphor.bob.treeViewObject;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Tree {

  private final TreeView<GameObject<?>> treeView;

  private final List<Class<? extends GameObject<?>>> itemTypes = Arrays.asList(
      Account.class, GameCharacter.class, Item.class, Information.class
  );

  public Tree(ObservableList<Account> accounts) {
    treeView = new TreeView<>();

    GameObject<?> root = new GameObject<Account>("") {

      @Override
      public ObservableList<Account> getItems() {
        return accounts;
      }

      @Override
      public void createAndAddChild(String name) {
        getItems().add(new Account(name));
      }

    };

    TreeItem<GameObject<?>> treeRoot = createItem(root);

    treeView.setRoot(treeRoot);
    treeView.setShowRoot(false);

    treeView.setCellFactory(tv -> {

      TreeCell<GameObject<?>> cell = new TreeCell<GameObject<?>>() {

        @Override
        protected void updateItem(GameObject<?> item, boolean empty) {
          super.updateItem(item, empty);
          textProperty().unbind();
          if (empty) {
            setText(null);
            itemTypes.stream().map(Tree.this::asPseudoClass).forEach(pc -> pseudoClassStateChanged(pc, false));
          } else {
            textProperty().bind(item.nameProperty());
            PseudoClass itemPC = asPseudoClass(item.getClass());
            itemTypes.stream().map(Tree.this::asPseudoClass).forEach(pc -> pseudoClassStateChanged(pc, itemPC.equals(pc)));
          }
        }
      };

      cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
        if (isNowHovered && (!cell.isEmpty())) {
          System.out.println("Mouse hover on " + cell.getItem().getName());
        }
      });

      return cell;
    });
  }

  public TreeView<GameObject<?>> getTreeView() {
    return treeView;
  }

  private TreeItem<GameObject<?>> createItem(GameObject<?> object) {

    // create tree item with children from game object's list:

    TreeItem<GameObject<?>> item = new TreeItem<>(object);
    item.setExpanded(true);
    item.getChildren().addAll(object.getItems().stream().map(this::createItem).collect(toList()));

    // update tree item's children list if game object's list changes:

    object.getItems().addListener((Change<? extends GameObject<?>> c) -> {
      while (c.next()) {
        if (c.wasAdded()) {
          item.getChildren().addAll(c.getAddedSubList().stream().map(this::createItem).collect(toList()));
        }
        if (c.wasRemoved()) {
          item.getChildren().removeIf(treeItem -> c.getRemoved().contains(treeItem.getValue()));
        }
      }
    });

    return item;
  }

  private PseudoClass asPseudoClass(Class<?> clz) {
    return PseudoClass.getPseudoClass(clz.getSimpleName().toLowerCase());
  }

}