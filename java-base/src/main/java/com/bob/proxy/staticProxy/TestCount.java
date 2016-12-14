package com.bob.proxy.staticProxy;

/**
 * Created by Bob on 2016/12/14.
 */
public class TestCount {
  public static void main(String[] args) {
    CountProxy countProxy = new CountProxy(new CountImpl());
    countProxy.updateCount();
    countProxy.queryCount();
  }
}
