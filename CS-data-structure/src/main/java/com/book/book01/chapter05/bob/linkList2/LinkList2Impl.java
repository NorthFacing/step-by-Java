package com.book.book01.chapter05.bob.linkList2;

/**
 * Created by Bob on 2016/5/26.
 */
public class LinkList2Impl implements LinkList2 {

  public Link first;

  @Override
  public Link find(int key) { // 跟书本范例实现不一致，可以去参考下实现方法
    Link temp = this.first;
    while (temp != null) {
      if (temp.iData == key) {
        return temp;
      } else {
        temp = temp.next;
      }
    }
    return null;
  }

  @Override
  public Link delete(int key) { // 跟书本范例实现不一致，可以去参考下实现方法
    Link temp = this.first;
    Link previous = this.first;
    while (temp != null) {
      if (temp.iData == key) {
        if (temp == this.first) {
          this.first = this.first.next;
        } else {
          previous.next = temp.next;
        }
        return temp;
      } else {
        temp = temp.next;
      }
    }
    return null;
  }

  //================================================

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public void insertFirst(int iData, double dData) {
    Link link = new Link(iData, dData);
    link.next = first;
    first = link;
  }

  @Override
  public Link deleteFirst() {
    Link temp = this.first;
    this.first = first.next;
    return temp;
  }

  @Override
  public void displayList() {
    Link temp = this.first;
    while (temp != null) {
      temp.displayLink();
      temp = temp.next;
    }
  }


}
