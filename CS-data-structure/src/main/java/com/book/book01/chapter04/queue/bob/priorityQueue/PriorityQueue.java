package com.book.book01.chapter04.queue.bob.priorityQueue;

/**
 * Created by Bob on 2016/5/20.
 */
public interface PriorityQueue {

  void insert(long item);

  long remove();

  long peek();

  boolean isEmpty();

  boolean isFull();

  int queueSize();

}
