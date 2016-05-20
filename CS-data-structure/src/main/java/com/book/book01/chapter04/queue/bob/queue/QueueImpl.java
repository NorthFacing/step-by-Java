package com.book.book01.chapter04.queue.bob.queue;

/**
 * Created by Bob on 2016/5/20.
 */
public class QueueImpl implements QueueInterface {

  private Object[] queue;
  private int maxSize;
  private int countSize;
  private int front;
  private int rear;

  public QueueImpl(int i) {
    queue = new Object[i];
    maxSize = i;
    countSize = 0;
    front = 0;
    rear = -1;
  }

  @Override
  public void insert(Object j) {
    if (rear == maxSize - 1) {
      rear = -1;
    }
    queue[++rear] = j;
    countSize++;
  }

  @Override
  public Object remove() {
    Object o = queue[front++];
    if (front == maxSize) {
      front = 0;
    }
    countSize--;
    return o;
  }

  @Override
  public Object peek() {
    return queue[front];
  }

  @Override
  public boolean isEmpty() {
    return countSize == 0;
  }

  @Override
  public boolean isFull() {
    return countSize == maxSize;
  }

  @Override
  public int queueSize() {
    return countSize;
  }
}
