package com.book.book01.chapter04.bob.stack;

/**
 * Created by Bob on 2016/5/9.
 */
public interface StackInterface {

  void push(long j);

  long peek();

  long pop();

  boolean isEmpty();

  boolean isFull();
}
