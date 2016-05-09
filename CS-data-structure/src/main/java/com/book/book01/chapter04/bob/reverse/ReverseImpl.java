package com.book.book01.chapter04.bob.reverse;

import com.book.book01.chapter04.bob.stack.StackImpl;

/**
 * Created by Bob on 2016/5/9.
 */
public class ReverseImpl {

  public String doReverse(String input) {
    StackImpl stack = new StackImpl(input.length());
    for (int i = 0; i < input.length(); i++) {
      stack.push(input.charAt(i));
    }
    String output = "";
    while (!stack.isEmpty()) {
      output += (char)stack.pop();
    }
    return output;
  }

}
