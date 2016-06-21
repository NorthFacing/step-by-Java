package com.book.book01.chapter03.bob.selectSort;

/**
 * Created by Bob on 2016/6/21.
 */
public class SelectSortDemo {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    SelectSort arr;                 // reference to array
    arr = new SelectSortImpl(maxSize);  // create the array

    arr.insert(77);               // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);

    arr.display();                // display items

    arr.selectSort();          // selection-sort them

    arr.display();                // display them again
  }
}
