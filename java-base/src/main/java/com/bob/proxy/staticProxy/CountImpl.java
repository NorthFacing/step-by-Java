package com.bob.proxy.staticProxy;

/**
 * Created by Bob on 2016/12/14.
 */
public class CountImpl implements Count {
  @Override
  public void queryCount() {
    System.out.println("Check the account method...");
  }

  @Override
  public void updateCount() {
    System.out.println("Modify account method...");
  }
}
