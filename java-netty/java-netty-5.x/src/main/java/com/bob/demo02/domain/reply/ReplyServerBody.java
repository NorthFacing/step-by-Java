package com.bob.demo02.domain.reply;

/**
 * Created by Bob on 2016/4/13.
 */
public class ReplyServerBody extends ReplyBody {
  private String serverInfo;

  public ReplyServerBody(String serverInfo) {
    this.serverInfo = serverInfo;
  }

  public String getServerInfo() {
    return serverInfo;
  }

  public void setServerInfo(String serverInfo) {
    this.serverInfo = serverInfo;
  }
}
