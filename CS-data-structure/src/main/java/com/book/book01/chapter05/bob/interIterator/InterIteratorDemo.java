package com.book.book01.chapter05.bob.interIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bob on 2016/6/28.
 */
public class InterIteratorDemo {

  public static void main(String[] args) throws IOException {

    LinkList theList = new LinkListImpl();           // new list
    ListIterator iter1 = theList.getIterator();  // new iter
    long value;

    iter1.insertAfter(20);             // insert items
    iter1.insertAfter(40);
    iter1.insertAfter(80);
    iter1.insertBefore(60);

    while (true) {
      System.out.print("Enter first letter of show, reset, ");
      System.out.print("next, get, before, after, delete: ");
      System.out.flush();
      int choice = getChar();         // get user's option
      switch (choice) {
        case 's':                    // show list
          if (!theList.isEmpty())
            theList.displayList();
          else
            System.out.println("List is empty");
          System.out.println();
          break;
        case 'r':                    // reset (to first)
          iter1.reset();
          break;
        case 'n':                    // advance to next item
          if (!theList.isEmpty() && !iter1.atEnd())
            iter1.nextLink();
          else
            System.out.println("Can't go to next link");
          break;
        case 'g':                    // get current item
          if (!theList.isEmpty()) {
            value = iter1.getCurrent().dData;
            System.out.println("Returned " + value);
          } else
            System.out.println("List is empty");
          break;
        case 'b':                    // insert before current
          System.out.print("Enter value to insert: ");
          System.out.flush();
          value = getInt();
          iter1.insertBefore(value);
          break;
        case 'a':                    // insert after current
          System.out.print("Enter value to insert: ");
          System.out.flush();
          value = getInt();
          iter1.insertAfter(value);
          break;
        case 'd':                    // delete current item
          if (!theList.isEmpty()) {
            value = iter1.deleteCurrent();
            System.out.println("Deleted " + value);
          } else
            System.out.println("Can't delete");
          break;
        default:
          System.out.println("Invalid entry");
      }  // end switch
    }  // end while
  }  // end main()
//--------------------------------------------------------------

  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }

  //-------------------------------------------------------------
  public static char getChar() throws IOException {
    String s = getString();
    return s.charAt(0);
  }

  //-------------------------------------------------------------
  public static int getInt() throws IOException {
    String s = getString();
    return Integer.parseInt(s);
  }
//-------------------------------------------------------------
}  // end class InterIterApp
