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

  //  @Override
  public void shellSort3() {
    int inner, outer;
    long temp;

    int h = 1;                      // 增量 h
    while (h <= len / 3)
      h = h * 3 + 1;                // 使用Knuth序列生成方法：1, 4, 13, 40, 121, ...

    while (h > 0) {
      for (outer = h; outer < len; outer++) { //
        temp = arr[outer];
        inner = outer;
        while (inner > h - 1 && arr[inner - h] >= temp) {
          arr[inner] = arr[inner - h];
          inner = inner - h;
          arr[inner] = temp;
        }
      }
      h = (h - 1) / 3;              // 逐步缩小间距，相当于增大有序数组数量，但此时的数据需要移动的距离小于当前增量
    }
  }

  @Override
  public void shellSort() {
    int cur;
    int inner, outer;
    long temp;

    int h = 1;                      // 增量 h
    while (h <= len / 3)
      h = h * 3 + 1;                // 使用Knuth序列生成方法：1, 4, 13, 40, 121, ...

    while (h > 0) {
      System.out.println();

      for (outer = h; outer < len; outer++) { // 每次比较往后移动一位
        inner = outer; // 将 inner 和 outer 置于同一个位置

        temp = arr[outer];  // 将out先放入辅助变量空间

        while (inner > h - 1 && arr[inner - h] >= temp) { // 比较
          arr[inner] = arr[inner - h];
          inner = inner - h;
        }
        arr[inner] = temp;
      }
      h = (h - 1) / 3;              // 逐步缩小间距，相当于增大有序数组数量，但此时的数据需要移动的距离小于当前增量
    }

    while (h > 0) {
      System.out.println();

      for (cur = h; cur < len; cur++) { // 每次比较往后移动一位

        int bj = cur - h;

        while (arr[bj] > arr[cur]) { // 如果前面的数据大，进行交换

          long temp2 = arr[bj];
          arr[bj] = arr[cur];
          arr[cur] = temp2;

        }
      }
      this.display();
      h = (h - 1) / 3;              // 逐步缩小间距，相当于增大有序数组数量，但此时的数据需要移动的距离小于当前增量
    }
  }
}
