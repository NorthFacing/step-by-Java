package com.book.book01.chapter04.stack.bob.stack;

/**
 * Created by Bob on 2016/5/9.
 */
public class StackDemo {
  public static void main(String[] args) {
    StackImpl stack = new StackImpl(10);
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);

    System.out.println("Test isFull fun:");
    System.out.println(stack.isFull());


    System.out.println("Test peek fun:");
    long peek = (long) stack.peek();
    System.out.println(peek);

    System.out.println("Test pop fun:");
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }
}
