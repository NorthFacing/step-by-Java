package com.book.book01.chapter03.bob.insertSort;

/**
 * Created by Bob on 2016/6/21.
 */
public class InsertSortDemo {
  public static void main(String[] args) {
    int maxSize = 100;            // array size
    InsertSort arr;                 // reference to array
    arr = new InsertSortImpl(maxSize);  // create the array

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

    arr.display();

    arr.insertSort();

    arr.display();
  }
}
