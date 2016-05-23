package com.book.book01.chapter04.queue.bob.priorityQueue;

/**
 * Created by Bob on 2016/5/20.
 */
public class PriorityQueueImpl implements PriorityQueue {

  private int maxSize;
  private long[] queArray;
  private int nItems;

  public PriorityQueueImpl(int len) {
    maxSize = len;
    queArray = new long[len];
    nItems = 0;
  }

  @Override
  public void insert(long item) {
    int j;
    if (nItems == 0) {
      queArray[nItems++] = item;
    } else {
      for (j = nItems - 1; j >= 0; j--) {
        if (item > queArray[j]) {
          queArray[j + 1] = queArray[j];
        } else {
          break;
        }
      }
      queArray[j + 1] = item;
      nItems++;
    }
  }

  @Override
  public long remove() {
    return queArray[--nItems];
  }

  @Override
  public long peek() {
    return queArray[nItems - 1];
  }

  @Override
  public boolean isEmpty() {
    return nItems == 0;
  }

  @Override
  public boolean isFull() {
    return nItems == maxSize;
  }

  @Override
  public int queueSize() {
    return nItems;
  }
}
