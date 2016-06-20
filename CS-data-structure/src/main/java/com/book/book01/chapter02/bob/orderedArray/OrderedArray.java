package com.book.book01.chapter02.bob.orderedArray;

/**
 * Created by Bob on 2016/6/14.
 */
public interface OrderedArray {

  int size();

  int find(long searchKey);

  void insert(long value); // 按照正序排列

  boolean delete(long value);

  void display();

}
