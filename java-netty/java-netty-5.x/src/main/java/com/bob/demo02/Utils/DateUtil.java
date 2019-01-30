package com.bob.demo02.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bob on 2016/4/14.
 */
public class DateUtil {

  public static String getStrDate() {
    return dateToStr(new Date());
  }

  public static String dateToStr(Date date) {
    return dateToStr(date, "yy-MM-dd HH:mm:ss");
  }

  public static String dateToStr(Date date, String form) {
    SimpleDateFormat format = new SimpleDateFormat(form);
    String str = format.format(date);
    return str;
  }

  public static void main(String[] args) {
    System.out.println(dateToStr(new Date()));
  }
}
