package com.book.book01.chapter04.stack.bob.bracket;

/**
 * Created by Bob on 2016/5/20.
 */
public class BracketDemo {
  public static void main(String[] args) {
    String input = "asdf{asdf}asdf{sdf[(asdf0)](}asdf";
    BracketService bracket = new BracketService();
    bracket.bracketCheck(input);
  }
}
