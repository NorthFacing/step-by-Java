package com.book.book01.chapter02.bob.highArray;

/**
 * Created by Bob on 2016/6/14.
 */
public interface HighArray {

  int size(); // 数组当前数据长度

  boolean find(long searchKey); // 根据值查找

  void insert(long value); // 插入

  boolean delete(long value); // 删除(删除找到的第一个数据即可)：1.先找出需要删除的数据，2.最后一个数据需要特殊处理

  void display(); // 打印全部数据

}
