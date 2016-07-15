package com.book.book01.chapter07.bob.shellSort;

import java.util.ArrayList;

/**
 * Created by Bob on 2016/7/13.
 */
public class ShellSortDemo {

  private static ArrayList<Long> exists = new ArrayList<>();


  public static void main(String[] args) {
    int maxSize = 10;             // array size
    ShellSortService arr;
    arr = new ShellSortServiceImpl(maxSize);   // create the array

    for (int j = 0; j < maxSize; j++)  // fill array with
    {                          // random numbers
//      long n = getNum();
//      arr.insert(n);
      arr.insert(maxSize - j);
    }
    arr.display();                // display unsorted array
    arr.shellSort();              // shell sort the array
    arr.display();                // display sorted array
  }


  private static long getNum() {
    long n = (int) (java.lang.Math.random() * 99);
    if (exists.contains(n))
      n = getNum();
    exists.add(n);
    return n;
  }
}
