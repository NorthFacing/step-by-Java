package com.book.book01.chapter06.bob.mergeSort;

/**
 * Created by Bob on 2016/7/4.
 */
public class MergeServiceImpl implements MergeService {

  private long[] arr; // 数组容器
  private int len; // 当前数组长度

  public MergeServiceImpl(int maxSize) {
    arr = new long[maxSize];
    len = 0;
  }

  @Override
  public void insert(long value) {
    arr[len++] = value;
  }

  /**
   * @Step1 平分数组
   * @Step2 分别排序
   * @Step3 归并
   * @Step4 递归调用
   */
  @Override
  public void mergeSort() {
    /**
     * 这里recSpace的主要作用是辅助存储
     */
    long[] recSpace = new long[len];

    recMergeSort(recSpace, 0, len - 1);

    System.out.println("\n执行排序");
  }

  /**
   * 分段处理，迭代计算
   *
   * @param recSpace
   * @param start
   * @param end
   */
  private void recMergeSort(long[] recSpace, int start, int end) {
    if (start == end)
      return;
    int mid = (start + end) / 2; // 分两段进行排序，直接进行递归调用，这样可以保证merge方法中都是都是排好序的数据
    recMergeSort(recSpace, start, mid); // 分段排序使用的是同一个临时空间，用不完就空着
    recMergeSort(recSpace, mid + 1, end);
    merge(recSpace, start, mid, mid + 1, end); //
  }

  /**
   * 归并有序数组
   *
   * @param recSpace 辅助空间变量
   * @param start1   前半部分开始下标
   * @param end1     前半部分结束下标
   * @param start2   后半部分开始下标
   * @param end2     后半部分结束下标
   */
  private void merge(long[] recSpace, int start1, int end1, int start2, int end2) {

    int j = 0; // workspace index
    int n = end2 - start1 + 1; // # 数组长度
    int startIndex = start1; // 从辅助变量拷贝数据到原数组的开始坐标（因为使用了迭代分布排序，所以需要记住排序数据段的位置）

    while (start1 <= end1 && start2 <= end2)
      if (arr[start1] < arr[start2])
        recSpace[j++] = arr[start1++];
      else
        recSpace[j++] = arr[start2++];

    while (start1 <= end1)
      recSpace[j++] = arr[start1++];

    while (start2 <= end2)
      recSpace[j++] = arr[start2++];

    // 将排好序的数据写入到原数组，覆盖原乱序数据
    for (j = 0; j < n; j++) // 注意这里 j=0 重新赋值了，跟上面的 j++ 无关
      arr[startIndex + j] = recSpace[j];

    System.out.print("\ndisplay = ");
    display();
    int length = recSpace.length;
    System.out.print("\nworkSpa = ");
    for (int i = 0; i < length; i++) {
      System.out.print(recSpace[i] + " ");
    }
    System.out.println();
  }

  @Override
  public void display() {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

