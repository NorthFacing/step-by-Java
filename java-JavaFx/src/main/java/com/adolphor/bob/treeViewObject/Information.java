package com.adolphor.bob.treeViewObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Information extends GameObject<GameObject<?>> {

  public Information(String name) {
    super(name);
  }

  @Override
  public ObservableList<GameObject<?>> getItems() {
    return FXCollections.emptyObservableList();
  }

  @Override
  public void createAndAddChild(String name) {
    throw new IllegalStateException("Information has no child items");
  }

}
