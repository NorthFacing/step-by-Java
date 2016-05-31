package com.book.book01.chapter05.bob.doublyLinked;

/**
 * Created by Bob on 2016/5/31.
 */
public class DoublyLinkedListImpl implements DoublyLinkedList {

  public DoublyLink first;
  public DoublyLink last;

  @Override
  public boolean isEmpty() {
    return (first == null);
  }

  @Override
  public void insertFirst(long dd) {
    DoublyLink newLink = new DoublyLink(dd);
    if (first == null) {
      last = newLink;
    } else {
      first.prev = newLink;
      newLink.next = first;
    }
    first = newLink;
  }

  @Override
  public void insertLast(long dd) {
    DoublyLink newLink = new DoublyLink(dd);
    if (last == null) {
      first = newLink;
      last = newLink;
    } else {
      newLink.prev = last;
      last.next = newLink;
    }
    last = newLink;
  }

  @Override
  public DoublyLink deleteFirst() {
    if (isEmpty())
      return null;

    DoublyLink temp = first;
    if (first.next == null) {
      first = null;
      last = null;
    } else {
      first = first.next;
      first.prev = null;
    }
    return temp;
  }

  @Override
  public DoublyLink deleteLast() {
    if (isEmpty())
      return null;
    DoublyLink temp = last;
    if (last.prev == null) {
      first = null;
      last = null;
    } else {
      last = last.prev;
      last.next = null;
    }
    return temp;
  }

  @Override
  public boolean insertAfter(long key, long dd) {

//    if (isEmpty())
//      return false;
//
//    DoublyLink newLink = new DoublyLink(dd);
//    DoublyLink temp = first;
//    while (temp != null) {
//      if (temp.dData == dd) {
//        if (temp.next == null) {
//          last = newLink;
//        } else {
//          newLink.next = temp.next;
//          temp.next.prev = newLink;
//        }
//        newLink.prev = temp;
//        return true;
//      } else
//        temp = temp.next;
//    }
//    return false;

    DoublyLink current = first;          // start at beginning
    while (current.dData != key)    // until match is found,
    {
      current = current.next;     // move to next link
      if (current == null)
        return false;            // didn't find it
    }

    DoublyLink newLink = new DoublyLink(dd);   // make new link
    if (current == last)            // if last link,
    {
      newLink.next = null;          // newLink --> null
      last = newLink;               // newLink <-- last
    } else                          // not last link,
    {
      newLink.next = current.next;  // newLink --> old next
      // newLink <-- old next
      current.next.prev = newLink;
    }
    newLink.prev = current;        // old current <-- newLink
    current.next = newLink;        // old current --> newLink
    return true;                   // found it, did insertion

  }

  /**
   * 自己实现的不好，嵌套太多
   *
   * @param key
   * @return
   */
  @Override
  public DoublyLink deleteKey(long key) {
    DoublyLink current = first;          // start at beginning
    while (current.dData != key)    // until match is found,
    {
      current = current.next;     // move to next link
      if (current == null)
        return null;             // didn't find it
    }
    if (current == first)             // found it; first item?
      first = current.next;       // first --> old next
    else                           // not first
      // old previous --> old next
      current.prev.next = current.next;

    if (current == last)              // last item?
      last = current.prev;    // old previous <-- last
    else                           // not last
      // old previous <-- old next
      current.next.prev = current.prev;
    return current;                // return value
  }

  @Override
  public void displayForward() {
    System.out.print("List (first-->last): ");
    DoublyLink current = first;          // start at beginning
    while (current != null)         // until end of list,
    {
      current.displayLink();      // display data
      current = current.next;     // move to next link
    }
    System.out.println("");

  }

  @Override
  public void displayBackward() {
    System.out.print("List (last-->first): ");
    DoublyLink current = last;           // start at end
    while (current != null)         // until start of list,
    {
      current.displayLink();      // display data
      current = current.prev; // move to previous link
    }
    System.out.println("");

  }
}
