package com.video.video01.v02_c02_线性结构;

/**
 * Created by Bob on 2016/7/8.
 */
public class C_2_1_D02 {
  public static void main(String[] args) {

    // 用结构数组表示 f(x)=9x^12+15x^8+3x^2，以及f(x)=26x^19-4x^8-13x^6+82
    // 视频中一个数组元素中存储了系数和指数两个元素，但没有说明使用何种存储结构，这里使用了2维数组来表示

    int[][] func1 = getFunc1();

    int[][] func2 = getFunc2();

    printFun(func1);
    printFun(func2);

  }

  private static void printFun(int[][] funcArr) {
    System.out.print("方程式为：\n f(x) = ");
    for (int i = 0; i < funcArr.length; i++) {
      int[] item = funcArr[i];  // 数据结构中的元素项
      int factor = item[0];   // 系数
      int power = item[1];    // 指数

      String strFactor = "";
      if (i == 0 || factor < 0) {
        strFactor = "" + factor;
      } else if (factor > 0) {
        strFactor = "+" + factor;
      }

      String strPower = "";
      if (power == 1) {
        strPower = "x";
      } else if (power > 1) {
        strPower = "x^" + power;
      }

      System.out.print(strFactor + strPower);

    }
    System.out.println("\n");
  }

  private static int[][] getFunc2() {
    int[][] func2 = new int[4][2];
    func2[0][0] = 26;
    func2[0][1] = 19;
    func2[1][0] = -4;
    func2[1][1] = 8;
    func2[2][0] = -13;
    func2[2][1] = 6;
    func2[3][0] = 82;
    func2[3][1] = 0;
    return func2;
  }

  private static int[][] getFunc1() {
    int[][] func1 = new int[3][2];
    func1[0][0] = 9;
    func1[0][1] = 12;
    func1[1][0] = 15;
    func1[1][1] = 8;
    func1[2][0] = 3;
    func1[2][1] = 2;
    return func1;
  }
}
