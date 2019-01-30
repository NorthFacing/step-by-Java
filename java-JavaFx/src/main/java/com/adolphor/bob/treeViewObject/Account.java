package com.adolphor.bob.treeViewObject;

// 第一层级
public class Account extends GameObject<GameCharacter> {

  public Account(String name) {
    super(name);
  }

  @Override
  public void createAndAddChild(String name) {
    getItems().add(new GameCharacter(name));
  }

}