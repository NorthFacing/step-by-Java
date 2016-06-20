package structuralDesignPatterns.proxy.demo02;

import java.util.Date;

/**
 * Created by Bob on 2016/6/16.
 */
public abstract class Thing {

  public void sayHello() {
    System.out.println(this.getClass().getSimpleName() + " says howdy at " + new Date());
  }

}