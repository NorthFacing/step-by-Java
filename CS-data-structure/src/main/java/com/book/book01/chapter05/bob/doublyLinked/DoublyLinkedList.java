package com.book.book01.chapter05.bob.doublyLinked;

/**
 * Created by Bob on 2016/5/31.
 */
public interface DoublyLinkedList {

  boolean isEmpty();

  void insertFirst(long dd);

  void insertLast(long dd);

  DoublyLink deleteFirst();

  DoublyLink deleteLast();

  boolean insertAfter(long key, long dd);

  DoublyLink deleteKey(long key);

  void displayForward();

  void displayBackward();

}
