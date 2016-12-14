package com.bob.proxy.more;

/**
 * Created by Bob on 2016/12/14.
 */
public class CountServiceImpl implements CountService {
  private int count = 0;
  @Override
  public int count() {
    return count ++;
  }
}
