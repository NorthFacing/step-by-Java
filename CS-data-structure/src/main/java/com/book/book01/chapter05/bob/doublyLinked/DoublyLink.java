package com.book.book01.chapter05.bob.doublyLinked;

/**
 * Created by Bob on 2016/5/31.
 */
public class DoublyLink {

  public long dData;
  public DoublyLink next;
  public DoublyLink prev;

  public DoublyLink(long dData) {
    this.dData = dData;
  }

  public void displayLink() {
    System.out.print(dData + " ");
  }

}
