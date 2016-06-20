package structuralDesignPatterns.proxy.demo02;

import java.util.Date;

/**
 * Created by Bob on 2016/6/16.
 */
public class Proxy {

  SlowThing slowThing;

  public Proxy() {
    System.out.println("Creating proxy at " + new Date());
  }

  public void sayHello() {
    if (slowThing == null) {
      slowThing = new SlowThing();
    }
    slowThing.sayHello();
  }

}