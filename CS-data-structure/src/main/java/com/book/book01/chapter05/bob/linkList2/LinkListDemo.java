package com.book.book01.chapter05.bob.linkList2;

import com.book.book01.chapter05.bob.linkList.Link;

/**
 * Created by Bob on 2016/5/26.
 */
public class LinkListDemo {
  public static void main(String[] args) {
    LinkList theList = new LinkList();

    theList.insertFirst(222, 2.99);
    theList.insertFirst(444, 4.99);
    theList.insertFirst(666, 6.99);
    theList.insertFirst(888, 8.99);
    theList.insertFirst(999, 9.99);

    System.out.println("list display:");
    theList.displayList();
    System.out.println();

    System.out.println("list find:888");
    Link link = theList.find(888);
    link.displayLink();
    System.out.println();

    System.out.println("delete:888");
    theList.delete(888);

    System.out.println("list display:");
    theList.displayList();
  }
}
