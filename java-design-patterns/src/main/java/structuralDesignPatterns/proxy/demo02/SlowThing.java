package structuralDesignPatterns.proxy.demo02;

/**
 * Created by Bob on 2016/6/16.
 */
public class SlowThing extends Thing {

  public SlowThing() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}