package com.video.video01.v02_c02_线性结构;

/**
 * Created by Bob on 2016/7/8.
 */
public class C_2_1_D01 {
  public static void main(String[] args) {

    // 用数组表示 f(x)=4x^5-3x^2+1
    int[] arr = new int[6]; // 数组的长度就是方程式中x的幂的最大值

    arr[0] = 1; // 0次幂项系数为1
    arr[1] = 0;// 1次幂项系数为0
    arr[2] = -3;// 2次幂项系数为-3
    arr[3] = 0;
    arr[4] = 0;
    arr[5] = 4; // 5次幂项系数为4

    System.out.println("存储的方程式为：");
    System.out.print("f(x)=");
    for (int i = 5; i >= 0; i--) {
      if (arr[i] > 0) {
        System.out.print("+" + arr[i] + "x^" + i);
      } else if (arr[i] < 0) {
        System.out.print(arr[i] + "x^" + i);
      }
    }


    // 当x幂次过高，就会占用过多存储空间；极端情况如下：
    // f(x)=4x^2000-1，虽然只有两个有效项，但是要占用2001个数组元素，造成浪费


  }
}
