package com.book.book01.chapter04.queue.bob.queue;

/**
 * Created by Bob on 2016/5/20.
 */
public interface QueueInterface {

  void insert(Object j); // 增加数据到队尾

  Object remove(); // 移除队列头部的数据

  Object peek(); // 查看队列头部的数据

  boolean isEmpty();

  boolean isFull();

  int queueSize();
}
