package structuralDesignPatterns.proxy.demo03;

/**
 * Created by Bob on 2016/6/16.
 */
public class ProxyImage implements Image {

  private RealImage realImage;
  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(fileName);
    }
    realImage.display();
  }

}
