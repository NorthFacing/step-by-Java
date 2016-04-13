package com.bob.demo02.domain.reply;


/**
 * Created by Bob on 2016/4/13.
 */
public class ReplyClientBody extends ReplyBody {
  private String clientInfo;

  public ReplyClientBody(String clientInfo) {
    this.clientInfo = clientInfo;
  }

  public String getClientInfo() {
    return clientInfo;
  }

  public void setClientInfo(String clientInfo) {
    this.clientInfo = clientInfo;
  }
}
