package com.book.book01.chapter02.bob.array;

/**
 * Created by Bob on 2016/6/2.
 */
public class ArrayDemo {
  public static void main(String[] args) {
    /**
     * 初始化，插入，打印全部数据，查找，删除，打印全部数据
     */

    // 初始化
    long[] arr = new long[100];

    // 插入（20 - 30）
    for (int i = 0; i < 10; i++) {
      arr[i] = i + 20;
    }

    // 打印全部数据
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        System.out.print(arr[i] + " ");
      }
    }
    System.out.println();

    // 查找 25
    long search = 25;
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == search) {
        index = i;
      }
    }
    if (index == -1)
      System.out.println("未找到");
    else
      System.out.println("找到数字，下标为：" + index);


    // 删除23
    long del = 23;

    // 错了啊，笨蛋
//    for (int i = 0; i < 10; i++) {
//      if (arr[i] == del) {
//        if (i == 9)
//          arr[i] = 0;
//        else
//          arr[i] = arr[i + 1];
//      }
//    }
    for (int i = 0; i < 10; i++) {
      if (arr[i] == del) {
        for (int j = i; j < 10; j++) {
          if (j == 9)
            arr[j] = 0;
          else
            arr[j] = arr[j + 1];
        }
      }
    }


    // 打印全部数据
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        System.out.print(arr[i] + " ");
      }
    }
    System.out.println();

  }
}
