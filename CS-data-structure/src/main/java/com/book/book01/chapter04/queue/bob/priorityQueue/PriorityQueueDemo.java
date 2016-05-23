package com.book.book01.chapter04.queue.bob.priorityQueue;

/**
 * Created by Bob on 2016/5/23.
 */
public class PriorityQueueDemo {
  public static void main(String[] args) {
    PriorityQueueImpl thePQ = new PriorityQueueImpl(5);
    thePQ.insert(30);
    thePQ.insert(50);
    thePQ.insert(10);
    thePQ.insert(40);
    thePQ.insert(20);

    while (!thePQ.isEmpty()) {
      long item = thePQ.remove();
      System.out.print(item + " ");
    }
    System.out.println("");
  }
}
