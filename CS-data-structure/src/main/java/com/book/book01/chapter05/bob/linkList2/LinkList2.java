package com.book.book01.chapter05.bob.linkList2;

import com.book.book01.chapter05.bob.linkList.Link;
import com.book.book01.chapter05.bob.linkList.LinkList;

/**
 * Created by Bob on 2016/5/31.
 */
public interface LinkList2 extends LinkList{

  Link find(int key);

  Link delete(int key);
}
