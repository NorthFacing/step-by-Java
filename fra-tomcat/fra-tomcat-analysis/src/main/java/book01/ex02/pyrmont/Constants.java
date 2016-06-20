package book01.ex02.pyrmont;

import java.io.File;

public class Constants {
  public static final String WEB_ROOT =
          System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "webapp";

  public static final String PRODUCT_ROOT =
          System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java";

  public static final String PRODUCT_TARGET =
          System.getProperty("user.dir") + File.separator + "target";
}