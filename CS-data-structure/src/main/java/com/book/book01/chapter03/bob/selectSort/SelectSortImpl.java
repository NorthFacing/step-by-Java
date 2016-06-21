package com.book.book01.chapter03.bob.selectSort;

/**
 * Created by Bob on 2016/6/21.
 */
public class SelectSortImpl implements SelectSort {

  private long[] arr;
  private int len;

  public SelectSortImpl(int maxSize) {
    arr = new long[maxSize];
    len = 0;
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  @Override
  public void selectSort() {
    int out, in, temp;
    for (out = 0; out < len - 1; out++) { // len-1：剩最后一项的时候就没必要比较了，但是比较的话也不会出错
      temp = out;
      for (in = out + 1; in < len; in++) {// out+1：in要和out不一样，所以从+1开始比较
        if (arr[in] < arr[temp])          // 取出两者中比较小的值
          temp = in;
      }
      swap(out, temp);
    }
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  private void swap(int i, int j) {
    long temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
