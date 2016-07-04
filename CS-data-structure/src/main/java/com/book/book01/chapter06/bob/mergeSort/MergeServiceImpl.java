package com.book.book01.chapter06.bob.mergeSort;

/**
 * Created by Bob on 2016/7/4.
 */
public class MergeServiceImpl implements MergeService {

  private long[] arr; // 数组容器
  private int len; // 当前数组长度

  public MergeServiceImpl(int maxSize) {
    arr = new long[maxSize];
    len = 0;
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  // TODO
  @Override
  public void mergeSort() {
    System.out.println("\n执行排序");
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

