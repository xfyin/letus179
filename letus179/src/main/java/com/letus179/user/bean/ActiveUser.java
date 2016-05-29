/**
 * File：ActiveUser.java
 * Package：com.letus179.user.bean
 * Author：xfyin
 * Date：2016-5-26 下午10:37:25
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.user.bean;

import java.io.Serializable;

/**
 * 登入后的用户信息
 *
 * @author xfyin
 */
public class ActiveUser implements Serializable {
  
  /**
   * 序号
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * 用户
   */
  private String username;
  
  /**
   * 性别
   */
  private String gender;
  
  /**
   * @return username
   */
  public String getUsername() {
    return username;
  }
  
  /**
   * @param username set username
   */
  public void setUsername(String username) {
    this.username = username;
  }
  
  /**
   * @return gender
   */
  public String getGender() {
    return gender;
  }
  
  /**
   * @param gender set gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }
  
}
