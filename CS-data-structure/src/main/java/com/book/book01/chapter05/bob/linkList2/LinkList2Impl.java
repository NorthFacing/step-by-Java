package com.book.book01.chapter05.bob.linkList2;

import com.book.book01.chapter05.bob.linkList.Link;
import com.book.book01.chapter05.bob.linkList.LinkListImpl;

/**
 * Created by Bob on 2016/5/26.
 */
public class LinkList2Impl extends LinkListImpl implements LinkList2 {

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

}
