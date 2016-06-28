package com.book.book01.chapter05.bob.firstLastList;

/**
 * Created by Bob on 2016/5/26.
 */
public class Link {
  public int iData;
  public double dData;
  public Link next;

  public Link(int iData, double dData) {
    this.iData = iData;
    this.dData = dData;
  }

  public void displayLink() {
    System.out.print("{iData:" + iData + ",dData:" + dData + "}");
  }
}
