package com.adolphor.bob.treeViewObject;

public class Account extends GameObject<GameCharacter> {

  public Account(String name) {
    super(name);
  }

  @Override
  public void createAndAddChild(String name) {
    getItems().add(new GameCharacter(name));
  }

}