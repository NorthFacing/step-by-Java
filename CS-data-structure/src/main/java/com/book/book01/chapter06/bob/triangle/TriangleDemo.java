package com.book.book01.chapter06.bob.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bob on 2016/6/29.
 */
public class TriangleDemo {
  public static void main(String[] args) throws IOException {
    String input = getInput();

    int num = Integer.parseInt(input);

    System.out.println("\n打印倒三角：");
    printTriangle(num);

    System.out.println("\n Triangle sum = " + triangleSum(num));
  }

  private static int triangleSum(int n) {
    if (n == 1)
      return 1;
    else
      return (n + triangleSum(n - 1));
  }

  private static void printTriangle(int n) {
    int l = 1;
    int x = 0;
    for (int i = 0; i < n; i++) {
      System.out.print(i + " ");
      x++;
      if (x == l) {
        l++;
        x = 0;
        System.out.println();
      }
    }
    System.out.println();
  }

  private static String getInput() throws IOException {
    System.out.print("请输入数字并回车：");
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = bufferedReader.readLine();
    System.out.println("您输入的数字是：" + line);
    return line;
  }
}
