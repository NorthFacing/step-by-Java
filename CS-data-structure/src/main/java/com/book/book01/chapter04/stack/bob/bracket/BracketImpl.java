package com.book.book01.chapter04.stack.bob.bracket;

import com.book.book01.chapter04.stack.bob.stack.StackImpl;

/**
 * Created by Bob on 2016/5/9.
 */
public class BracketImpl {

  public void bracketCheck(String input) {

    int length = input.length();

    StackImpl stack = new StackImpl(length);

    for (int i = 0; i < length; i++) {
      char ch = input.charAt(i);
      switch (ch) {
        case '{':
        case '[':
        case '(':
          stack.push(ch);
          break;
        case ')':
        case ']':
        case '}':
          if (stack.isEmpty()) {
            System.err.println("缺失左括号");
          } else {
            char pop = (char) stack.pop();
            if ((ch == '}' && pop != '{')
                    || (ch == ']' && pop != '[')
                    || (ch == ')' && pop != '(')) {
              System.err.println("括号不匹配");
            }
          }
          break;
        default:
          break;
      }// end switch
    }// end for
    if(!stack.isEmpty()){
      System.err.println("缺失右括号");
    }
  }

}
