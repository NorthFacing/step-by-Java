package com.bob.io.io10_SystemInputAndOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bob on 2016/6/29.
 */
public class SystemInDemo {
  public static void main(String[] args) throws IOException {
    getInput();
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
