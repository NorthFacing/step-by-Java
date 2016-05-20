package com.book.book01.chapter04.queue.bob.queue;

/**
 * Created by Bob on 2016/5/20.
 */
public class QueueDemo {
  public static void main(String[] args) {
    QueueImpl theQueue = new QueueImpl(5);  // queue holds 5 items

    theQueue.insert(10);            // insert 4 items
    theQueue.insert(20);
    theQueue.insert(30);
    theQueue.insert(40);

    theQueue.remove();              // remove 3 items
    theQueue.remove();              //    (10, 20, 30)
    theQueue.remove();

    theQueue.insert(50);            // insert 4 more items
    theQueue.insert(60);            //    (wraps around)
    theQueue.insert(70);
    theQueue.insert(80);

    while (!theQueue.isEmpty())    // remove and display
    {                            //    all items
      int n = (int) theQueue.remove();  // (40, 50, 60, 70, 80)
      System.out.print(n);
      System.out.print(" ");
    }
    System.out.println("");
  }
}
