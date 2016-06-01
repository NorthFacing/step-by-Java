package com.book.book01.chapter05.homeWork.q01;

/**
 * Created by Bob on 2016/6/1.
 */
class Link {

  public long dData;
  public Link next;

  Link(long dData) {
    this.dData = dData;
  }

  public void display() {
    System.out.print(this.dData + " ");
  }

}

class LinkList {
  public Link first;
  public Link last;

  public LinkList() {
    first = null;
    last = null;
  }

  public void insert(long dData) {
    Link newLink = new Link(dData); // make new link
    // 范例实现
    Link previous = null;            // start at first
    Link current = first;
    // until end of list,
    while (current != null && dData > current.dData) {                             // or key > current,
      previous = current;
      current = current.next;       // go to next item
    }
    if (previous == null)               // at beginning of list
      first = newLink;              // first --> newLink
    else                             // not at beginning
      previous.next = newLink;      // old prev --> newLink
    newLink.next = current;          // newLink --> old currnt

    // 自己实现
//    if (first == null) {
//      first = newLink;
//      last = newLink;
//    } else {
//      Link temp = first;
//      Link prev = null;
//      while (temp != null && temp.data < data) {
//        prev = temp;
//        temp = temp.next;
//      }
//      if (prev == null) {
//        newLink.next = first;
//        first = newLink;
//      } else if (prev.next == null) {
//        prev.next = newLink;
//        last = newLink;
//      } else {
//        prev.next = newLink;
//        newLink.next = temp;
//      }
//    }
  }

  public long delete() {
    Link temp = first;
    first = first.next;
    return temp.dData;
  }

  public void displayList() {
    Link temp = first;
    while (temp != null) {
      temp.display();
      temp = temp.next;
    }
    System.out.println();
  }

}

public class SortedLinkedQueue {

  private LinkList linkListQueue = new LinkList();

  public void add(long data) {
    linkListQueue.insert(data);
  }

  public long remove() {
    return linkListQueue.delete();
  }

  public void displayQueue(){
    linkListQueue.displayList();
  }

}

class Demo {
  public static void main(String[] args) {
    SortedLinkedQueue queue = new SortedLinkedQueue();

    queue.displayQueue();
    queue.add(3);
    queue.add(5);
    queue.add(4);
    queue.add(9);
    queue.displayQueue();
    queue.remove();
    queue.displayQueue();
    queue.add(2);
    queue.add(7);
    queue.displayQueue();
    queue.remove();
    queue.displayQueue();

  }
}