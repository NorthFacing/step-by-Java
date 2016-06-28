package com.book.book01.chapter05.bob.interIterator;

/**
 * Created by Bob on 2016/6/28.
 */
public class Link {
  public long dData;             // data item
  public Link next;              // next link in list

  // -------------------------------------------------------------
  public Link(long dd)           // constructor
  {
    dData = dd;
  }

  // -------------------------------------------------------------
  public void displayLink()      // display ourself
  {
    System.out.print(dData + " ");
  }
}  // end class Link

