package com.book.book01.chapter07.bob.shellSort;

/**
 * Created by Bob on 2016/7/13.
 */
public class ShellSortServiceImpl implements ShellSortService {

  private long[] arr; // 数组容器
  private int len; // 当前数组长度

  public ShellSortServiceImpl(int maxSize) {
    arr = new long[maxSize];
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  @Override
  public void shellSort() {
    int inner, outer;
    long temp;

    int h = 1;                      // 增量 h
    while (h <= len / 3)
      h = h * 3 + 1;                // 使用Knuth序列生成方法：1, 4, 13, 40, 121, ...

    while (h > 0) {
      for (outer = h; outer < len; outer++) { //
        temp = arr[outer];
        inner = outer;

        System.out.println("temp:" + temp);

        while (inner > h - 1 && arr[inner - h] >= temp) {

          System.out.println("inner:" + inner + ",outer:" + outer);

          arr[inner] = arr[inner - h];
          inner -= h;
        }
        arr[inner] = temp;

        display();
        System.out.println();

      }
      h = (h - 1) / 3;              // 逐步缩小间距，相当于增大有序数组数量，但此时的数据需要移动的距离小于当前增量
    }
  }
}
