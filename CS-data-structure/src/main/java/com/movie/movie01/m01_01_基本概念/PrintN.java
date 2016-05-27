package com.movie.movie01.m01_01_基本概念;

/**
 * Created by Bob on 2016/5/27.
 */
public class PrintN {

  public static void main(String[] args) {
    Long n = 4000000000000000l;
//    printN1(n);
    System.out.println("=================================");
    printN2(n);
  }


  // 方法一：循环
  public static void printN1(long n) {
    for (long i = 0; i <= n; i++) {
      System.out.println(i);
    }
  }

  // 方法二：递归
  public static void printN2(long n) {
    if (n > 0) {
      printN2(n - 1);
      System.out.println(n);
    }
  }

}
