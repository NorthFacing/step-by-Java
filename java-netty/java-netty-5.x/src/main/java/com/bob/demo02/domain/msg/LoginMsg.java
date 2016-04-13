package com.bob.demo02.domain.msg;

/**
 * 登录类型消息
 * <p>
 * Created by Bob on 2016/4/13.
 */
public class LoginMsg extends BaseMsg {

  private String userName;
  private String password;

  public LoginMsg() {
    super();
    setType(MsgType.LOGIN);
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
