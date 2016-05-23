package com.book.book01.chapter04.stack.bob.reverse;

/**
 * Created by Bob on 2016/5/9.
 */
public class ReverseDemo {
  public static void main(String[] args) {
    ReverseService reverse = new ReverseService();
    String result = reverse.doReverse("reverseDemo");
    System.out.println(result);
  }
}
