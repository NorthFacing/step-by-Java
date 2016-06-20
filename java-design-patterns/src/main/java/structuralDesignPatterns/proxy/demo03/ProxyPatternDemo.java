package structuralDesignPatterns.proxy.demo03;

/**
 * Created by Bob on 2016/6/16.
 */
public class ProxyPatternDemo {

  public static void main(String[] args) {
    Image image = new ProxyImage("test_10mb.jpg");

    //image will be loaded from disk
    image.display();
    System.out.println("");

    //image will not be loaded from disk
    image.display();
  }

}
