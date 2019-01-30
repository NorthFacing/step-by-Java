package com.adolphor.bob.treeViewObject;

// 第三层
public class Item extends GameObject<Information> {

  public Item(String name) {
    super(name);
  }

  @Override
  public void createAndAddChild(String name) {
    getItems().add(new Information(name));
  }

}