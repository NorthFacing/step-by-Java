package com.book.book01.chapter04.bob.reverse;

/**
 * Created by Bob on 2016/5/9.
 */
public class ReverseDemo {
  public static void main(String[] args) {
    ReverseImpl reverse = new ReverseImpl();
    String result = reverse.doReverse("reverseDemo");
    System.out.println(result);
  }
}
