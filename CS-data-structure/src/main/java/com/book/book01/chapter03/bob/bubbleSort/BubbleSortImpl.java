package com.book.book01.chapter03.bob.bubbleSort;

/**
 * Created by Bob on 2016/6/21.
 */
public class BubbleSortImpl implements BubbleSort {

  private long[] arr;
  private int len;

  public BubbleSortImpl(int maxSize) {
    arr = new long[maxSize];
    this.len = 0;
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  @Override
  public void bubbleSort() {
    int out, in;
    for (out = len - 1; out > 1; out--) { // 只有两项的时候就不用比较了，但是即便携程out>0，也没有问题
      for (in = 0; in < out; in++) {
        if (arr[in] > arr[in + 1]) // out of order ?
          swap(in, in + 1);
      }
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
