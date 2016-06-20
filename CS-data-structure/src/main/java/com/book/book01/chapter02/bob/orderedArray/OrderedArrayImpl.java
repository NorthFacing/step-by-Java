package com.book.book01.chapter02.bob.orderedArray;

/**
 * Created by Bob on 2016/6/14.
 */
public class OrderedArrayImpl implements OrderedArray {

  private long[] arr;
  private int len;

  public OrderedArrayImpl(int max) {
    arr = new long[max];
    len = 0;
  }

  @Override
  public int size() {
    return len;
  }

  @Override
  public int find(long searchKey) { // 迭代
    int start = 0;
    int end = len;
    int temp = len / 2;

    while (true) {
      if (arr[temp] == searchKey) {
        return temp;
      } else if (arr[temp] > searchKey) {

      } else {

      }
    }

  }

  @Override
  public void insert(long value) {

  }

  @Override
  public boolean delete(long value) {
    return false;
  }

  @Override
  public void display() {

  }
}
