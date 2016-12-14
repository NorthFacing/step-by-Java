package com.bob.proxy.dynamicProxy;

/**
 * Created by Bob on 2016/12/14.
 */
public class BookFacadeImpl implements BookFacade {
  @Override
  public void addBook() {
    System.out.println("Books added method. . . ");
  }
}
