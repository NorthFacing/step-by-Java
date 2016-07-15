package com.book.book01.chapter07.bob.shellSort;

/**
 * Created by Bob on 2016/7/13.
 */
public class ShellSortDemo {
  public static void main(String[] args) {
    int maxSize = 10;             // array size
    ShellSortService arr;
    arr = new ShellSortServiceImpl(maxSize);   // create the array

    for (int j = 0; j < maxSize; j++)  // fill array with
    {                          // random numbers
      long n = (int) (java.lang.Math.random() * 99);
      arr.insert(n);
    }
    arr.display();                // display unsorted array
    arr.shellSort();              // shell sort the array
    arr.display();                // display sorted array
  }
}
