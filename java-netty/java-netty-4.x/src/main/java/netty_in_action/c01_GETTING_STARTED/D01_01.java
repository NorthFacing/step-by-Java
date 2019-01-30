package netty_in_action.c01_GETTING_STARTED;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 测试方法：
 * 1. 使用 telnet 127.0.0.1 1080 来建立socket连接
 * 2. 输入一般的msg字符信息
 * 3. 输入Done字符
 *
 * @author adolphor
 */
public class D01_01 {
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(1080);
    Socket clientSocket = serverSocket.accept();
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    String request, response;
    while ((request = in.readLine()) != null) {
      if ("Done".equals(request)) {
        break;
      }
      response = processRequest(request);
      out.println(response);
    }
  }

  public static String processRequest(String request) {
    System.out.println("get new msg: " + request);
    return request+" has been received";
  }
}
