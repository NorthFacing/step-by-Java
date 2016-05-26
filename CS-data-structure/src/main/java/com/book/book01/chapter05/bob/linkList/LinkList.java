package com.book.book01.chapter05.bob.linkList;

/**
 * Created by Bob on 2016/5/26.
 */
public class LinkList {
  public Link first;

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(int iData, double dData) {
    Link link = new Link(iData, dData);
    link.next = first;
    first = link;
  }

  public Link deleteFirst() {
    Link temp = this.first;
    this.first = first.next;
    return temp;
  }

  public void displayList() {
    Link temp = this.first;
    while (temp != null) {
      temp.displayLink();
      temp = temp.next;
    }
  }

}
