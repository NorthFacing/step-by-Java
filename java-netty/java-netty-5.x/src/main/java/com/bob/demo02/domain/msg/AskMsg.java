package com.bob.demo02.domain.msg;

/**
 * 请求类型消息
 * <p>
 * Created by Bob on 2016/4/13.
 */
public class AskMsg extends BaseMsg {

  public AskMsg() {
    super();
    setType(MsgType.ASK);
  }

  private AskParams params;

  public AskParams getParams() {
    return params;
  }

  public void setParams(AskParams params) {
    this.params = params;
  }

}
