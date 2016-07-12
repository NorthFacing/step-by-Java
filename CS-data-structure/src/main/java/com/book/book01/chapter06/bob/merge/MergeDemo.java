package com.book.book01.chapter06.bob.merge;

/**
 * Created by Bob on 2016/7/4.
 */
public class MergeDemo {
  public static void main(String[] args) {
    int[] arrayA = {23, 47, 81, 95};
    int[] arrayB = {7, 15, 39, 55, 62, 74};
    int[] arrayC = new int[10];

    merge(arrayA, 4, arrayB, 6, arrayC);
    display(arrayC, 10);

  }

  public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
    // 需要设置三个辅助变量
    int aIndex = 0, bIndex = 0, cIndex = 0;
    // 都不为空
    while (aIndex < sizeA && bIndex < sizeB) {
      if (arrayA[aIndex] < arrayB[bIndex]) {
        arrayC[cIndex++] = arrayA[aIndex++];
      } else {
        arrayC[cIndex++] = arrayB[bIndex++];
      }
    }
    // A是否遍历完成
    while (aIndex < sizeA) {
      arrayC[cIndex++] = arrayA[aIndex++];
    }
    // B是否遍历完成
    while (bIndex < sizeB) {
      arrayC[cIndex++] = arrayB[bIndex++];
    }
  }

  public static void display(int[] theArray, int size) {
    for (int j = 0; j < size; j++)
      System.out.print(theArray[j] + " ");
    System.out.println("");
  }
}
