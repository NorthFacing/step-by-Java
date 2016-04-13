package com.bob.demo02.domain.msg;

import java.io.Serializable;

/**
 * 请求类型参数
 * <p>
 * Created by Bob on 2016/4/13.
 */
public class AskParams implements Serializable {

  private static final long serialVersionUID = 1L;

  private String auth;

  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }

}
