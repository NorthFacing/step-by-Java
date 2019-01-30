package com.book.book01.chapter05.bob.linkList2;

/**
 * Created by Bob on 2016/5/31.
 */
public interface LinkList2 {

  Link find(int key);

  Link delete(int key);

  //==========================

  boolean isEmpty();

  void insertFirst(int iData, double dData);

  Link deleteFirst();

  void displayList();


}
