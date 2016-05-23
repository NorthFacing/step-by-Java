package com.book.book01.chapter04.stack.bob.reverse;

import com.book.book01.chapter04.stack.bob.stack.StackImpl;

/**
 * Created by Bob on 2016/5/9.
 */
public class ReverseService {
  public String doReverse(String input) {
    StackImpl stack = new StackImpl(input.length());
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      stack.push(c);
    }

    String output = "";
    while (!stack.isEmpty()) {
      char c = (char) stack.pop();
      output += c;
    }
    return output;
  }

}
