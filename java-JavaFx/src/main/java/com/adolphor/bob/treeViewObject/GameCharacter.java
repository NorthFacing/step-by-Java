package com.adolphor.bob.treeViewObject;

// 第二层
public class GameCharacter extends GameObject<GameObject<?>> {

  public GameCharacter(String name) {
    super(name);
  }

  @Override
  public void createAndAddChild(String name) {
    getItems().add(new Information(name));
  }

}