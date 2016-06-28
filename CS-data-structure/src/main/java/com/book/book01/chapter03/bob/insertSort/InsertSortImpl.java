package com.book.book01.chapter03.bob.insertSort;

/**
 * Created by Bob on 2016/6/21.
 */
public class InsertSortImpl implements InsertSort {

  private long[] arr;
  private int len;

  public InsertSortImpl(int maxSize) {
    arr = new long[maxSize];
    len = 0;
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  @Override
  public void insertSort() {
    int out, in;
    for (out = 1; out < len; out++) {
      long temp = arr[out];
      in = out;
      while (in > 0 && arr[in - 1] >= temp) {
        arr[in] = arr[in - 1];
        --in;
      }
      arr[in] = temp;
    }
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

}
