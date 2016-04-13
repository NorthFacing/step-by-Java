package com.bob.demo02.domain.reply;

import com.bob.demo02.domain.msg.BaseMsg;
import com.bob.demo02.domain.msg.MsgType;

/**
 * 响应类型消息
 * <p>
 * Created by Bob on 2016/4/13.
 */
public class ReplyMsg extends BaseMsg {

  public ReplyMsg() {
    super();
    setType(MsgType.REPLY);
  }

  private ReplyBody body;

  public ReplyBody getBody() {
    return body;
  }

  public void setBody(ReplyBody body) {
    this.body = body;
  }
}