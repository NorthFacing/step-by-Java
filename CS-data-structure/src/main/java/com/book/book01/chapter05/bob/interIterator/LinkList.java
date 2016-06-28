package com.book.book01.chapter05.bob.interIterator;

/**
 * Created by Bob on 2016/6/28.
 */
public interface LinkList {

  Link getFirst();

  void setFirst(Link f);

  boolean isEmpty();

  ListIterator getIterator();

  void displayList();
}
