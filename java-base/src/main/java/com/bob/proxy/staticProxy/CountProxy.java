package com.bob.proxy.staticProxy;

/**
 * Created by Bob on 2016/12/14.
 */
public class CountProxy implements Count {

  private CountImpl countImpl;

  public CountProxy(CountImpl countImpl) {
    this.countImpl = countImpl;
  }

  @Override
  public void queryCount() {
    System.out.println("Transaction processing before");
    // Method calls the delegate class;
    countImpl.queryCount();
    System.out.println("Transaction processing");
  }

  @Override
  public void updateCount() {
    System.out.println("Transaction processing before");
    // Method calls the delegate class;
    countImpl.updateCount();
    System.out.println("Transaction processing");
  }
}
