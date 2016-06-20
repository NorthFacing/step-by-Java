package structuralDesignPatterns.proxy.demo02;

/**
 * Created by Bob on 2016/6/16.
 */

public class ProxyDemo {

  public static void main(String[] args) {

    Proxy proxy = new Proxy();

    FastThing fastThing = new FastThing();
    fastThing.sayHello();

    proxy.sayHello();

  }

}