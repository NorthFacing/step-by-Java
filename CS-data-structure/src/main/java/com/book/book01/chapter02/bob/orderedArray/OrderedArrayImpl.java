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
  public int find(long searchKey) {
    int start = 0;
    int end = len - 1; // 下标要减1
    int temp;

    while (true) { // 迭代
      temp = (start + end) / 2;
      if (arr[temp] == searchKey) { // 1. 是否找到
        return temp;
      } else if (start > end) { // 2. 是否还可能找到
        return -1;
      } else {                  // 3. 接着找
        if (arr[temp] > searchKey) {  // 3.1 前半段
          end = temp - 1;
        } else {                      // 3.2 后半段
          start = temp + 1;
        }
        // 无论是前半段还是后半段，temp这个值都已经检查过了，所以进行加一或者减一操作
      }
    }

  }

  @Override
  public void insert(long value) {
    int i;
    for (i = 0; i < len; i++) {
      if (arr[i] > value)
        break;
    }

    for (int j = len; j > i; j--) {
      arr[j] = arr[j - 1];
    }
    arr[i] = value;
    len++;
  }

  @Override
  public boolean delete(long value) {
    int i = find(value);
    if (i > 0) {
      for (int j = i; j < len - 1; j++) {
        arr[j] = arr[j + 1];
      }
      len--;
      return true;
    } else
      return false;
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
