package com.book.book01.chapter04.bob.stack;

/**
 * Created by Bob on 2016/5/9.
 */
public class StackImpl implements StackInterface {

  private int maxSize;
  private long[] array;
  private int top;

  StackImpl(int maxSize) {
    this.maxSize = maxSize;
    array = new long[maxSize];
    top = -1;
  }

  @Override
  public void push(long j) {
    array[++top] = j;
  }

  @Override
  public long peek() {
    return array[top];
  }

  @Override
  public long pop() {
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
