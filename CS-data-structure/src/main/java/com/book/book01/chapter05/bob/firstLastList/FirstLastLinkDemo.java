package com.book.book01.chapter05.bob.firstLastList;

/**
 * Created by Bob on 2016/5/31.
 */
public class FirstLastLinkDemo {
  public static void main(String[] args) {
    FirstLastList theList = new FirstLastListImpl();

    System.out.println(theList.isEmpty());
    System.out.println();

    theList.insertFirst(22, 22);       // insert at front
    theList.insertFirst(44, 44);
    theList.insertFirst(66, 66);

    theList.insertLast(11, 11);        // insert at rear
    theList.insertLast(33, 33);
    theList.insertLast(55, 55);

    theList.displayList();         // display the list

    System.out.println();
    System.out.println();
    System.out.println(theList.isEmpty());
    System.out.println();

    theList.deleteFirst();         // delete first two items
    theList.deleteFirst();

    theList.displayList();         // display again
  }
}
