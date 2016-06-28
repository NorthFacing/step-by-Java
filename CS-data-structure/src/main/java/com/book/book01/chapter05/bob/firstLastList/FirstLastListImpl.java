package com.book.book01.chapter05.bob.firstLastList;

/**
 * Created by Bob on 2016/5/31.
 */
public class FirstLastListImpl implements FirstLastList {

  private Link first;
  private Link last;

  @Override
  public boolean isEmpty() {
    return (first == null);
  }

  @Override
  public void insertFirst(int iData, double dData) {
    Link newLink = new Link(iData, dData);
    if (first == null)
      last = newLink;
    else
      newLink.next = first;
    first = newLink;
  }

  @Override
  public void insertLast(int iData, double dData) {
    Link newLink = new Link(iData, dData);
    if (first == null)
      first = newLink;
    else
      last.next = newLink;
    last = newLink;

  }

  @Override
  public Link deleteFirst() {
    // 自己的实现
    Link temp = first.next;
    first = temp;
    if (temp == null) {
      last = null;
    }
    // 范例实现
//    Link temp = first;
//    if (first.next == null)
//      last = null;
//    first = first.next;
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
