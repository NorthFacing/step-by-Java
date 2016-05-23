package com.book.book01.chapter04.stack.bob.stack;

/**
 * Created by Bob on 2016/5/9.
 */
public class StackImpl implements Stack {

  private int maxSize;
  private Object[] array;
  private int top;

  public StackImpl(int maxSize) {
    this.maxSize = maxSize;
    array = new Object[maxSize];
    top = -1;
  }

  @Override
  public void push(Object j) {
    array[++top] = j;
  }

  @Override
  public Object peek() {
    return array[top];
  }

  @Override
  public Object pop() {
    return array[top--];
  }

  @Override
  public boolean isEmpty() {
    return (top == -1);
  }

  @Override
  public boolean isFull() {
    return (top == maxSize - 1);
  }
}
