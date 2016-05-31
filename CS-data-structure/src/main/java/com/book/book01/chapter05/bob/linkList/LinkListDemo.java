package com.book.book01.chapter05.bob.linkList;

/**
 * Created by Bob on 2016/5/26.
 */
public class LinkListDemo {
  public static void main(String[] args) {
    LinkList theList = new LinkListImpl();

    theList.insertFirst(222, 2.99);
    theList.insertFirst(444, 4.99);
    theList.insertFirst(666, 6.99);
    theList.insertFirst(888, 8.99);

    System.out.println("list display:");
    theList.displayList();

    System.out.println("delete:");
    while (!theList.isEmpty()) {
      Link aLink = theList.deleteFirst();
      aLink.displayLink();
    }

    System.out.println("list display:");
    theList.displayList();
  }
}
