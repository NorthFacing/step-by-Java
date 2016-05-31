package com.book.book01.chapter05.bob.linkList;

/**
 * Created by Bob on 2016/5/31.
 */
public interface LinkList {

  boolean isEmpty();

  void insertFirst(int iData, double dData);

  Link deleteFirst();

  void displayList();

}
