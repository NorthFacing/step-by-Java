package com.bob.demo02.domain.msg;

/**
 * 心跳检测Ping类型消息
 * <p>
 * Created by Bob on 2016/4/13.
 */
public class PingMsg extends BaseMsg {

  public PingMsg() {
    super();
    setType(MsgType.PING);
  }

}
