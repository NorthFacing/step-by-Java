package com.book.book01.chapter05.bob.firstLastList;

import com.book.book01.chapter05.bob.linkList.Link;

/**
 * Created by Bob on 2016/5/31.
 */
public interface FirstLastList {

  boolean isEmpty();

  void insertFirst(int iData, double dData);

  void insertLast(int iData, double dData);

  Link deleteFirst();

  void displayList();

}
