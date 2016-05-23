package com.book.book01.chapter04.stack.bob.stack;

/**
 * Created by Bob on 2016/5/9.
 */
public interface Stack {

  void push(Object j);

  Object pop();

  Object peek();

  boolean isEmpty();

  boolean isFull();
}
