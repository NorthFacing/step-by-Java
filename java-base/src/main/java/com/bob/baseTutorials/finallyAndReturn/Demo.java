package com.bob.baseTutorials.finallyAndReturn;

/**
 * Created by Bob on 2016/4/11.
 */
public class Demo {
  public static void main(String[] args) {
    Demo demo = new Demo();
    int test = demo.test();
    System.out.println("main:" + test);
  }

  private int test() {
    int x = 18;
    try {
      System.out.println("init:" + x);
      return getReturn(x);
    } finally {
      // 如果是基础数据类型，接收到的是erturn方法执行之前的数值，而且更改之后不影响return的返回
      x += 1;
      System.out.println("finally:" + x);
    }
  }

  private int getReturn(int x) {
    x += 2;
    System.out.println("return:" + x);
    return x;
  }

}
