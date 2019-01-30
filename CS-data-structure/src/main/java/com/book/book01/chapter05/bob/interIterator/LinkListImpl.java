package com.book.book01.chapter05.bob.interIterator;

/**
 * Created by Bob on 2016/6/28.
 */
public class LinkListImpl implements LinkList {

  private Link first;            // ref to first item on list

  // -------------------------------------------------------------
  public LinkListImpl()              // constructor
  {
    first = null;
  }           // no items on list yet

  // -------------------------------------------------------------
  public Link getFirst()         // get value of first
  {
    return first;
  }

  // -------------------------------------------------------------
  public void setFirst(Link f)   // set first to new link
  {
    first = f;
  }

  // -------------------------------------------------------------
  public boolean isEmpty()       // true if list is empty
  {
    return first == null;
  }

  // -------------------------------------------------------------
  public ListIterator getIterator()  // return iterator
  {
    return new ListIterator(this);  // initialized with
  }                               //    this list

  // -------------------------------------------------------------
  public void displayList() {
    Link current = first;       // start at beginning of list
    while (current != null)      // until end of list,
    {
      current.displayLink();   // print data
      current = current.next;  // move to next link
    }
    System.out.println("");
  }
// -------------------------------------------------------------
}  // end class LinkList

