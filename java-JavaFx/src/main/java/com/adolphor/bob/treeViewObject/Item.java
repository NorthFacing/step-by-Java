package com.adolphor.bob.treeViewObject;

public class Item extends GameObject<Information> {

  public Item(String name) {
    super(name);
  }

  @Override
  public void createAndAddChild(String name) {
    getItems().add(new Information(name));
  }

}