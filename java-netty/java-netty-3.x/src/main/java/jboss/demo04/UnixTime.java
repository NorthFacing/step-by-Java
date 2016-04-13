package jboss.demo04;

import java.util.Date;

/**
 * Created by Bob on 2016/4/12.
 */
public class UnixTime {
  private final int value;

  public UnixTime(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return new Date(value * 1000L).toString();
  }
}