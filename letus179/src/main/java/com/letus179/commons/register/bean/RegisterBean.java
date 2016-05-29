/**
 * File：RegisterBean.java
 * Package：com.letus179.commons.register.bean
 * Author：xfyin
 * Date：2016-5-28 下午3:30:11
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.register.bean;

import java.io.Serializable;

/**
 * 注册bean
 *
 * @author xfyin
 */
public class RegisterBean implements Serializable {
  
  /**
   * 序号
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * 无参
   */
  public RegisterBean() {
    super();
  }
  
  /**
   * @param realName
   * @param username
   * @param gender
   * @param password
   * @param birthdayYear
   * @param birthdayMonth
   * @param birthdayDay
   * @param phoneNum
   * @param email
   */
  public RegisterBean(String realName, String username, int gender, String password,
      String birthdayYear, String birthdayMonth, String birthdayDay, String phoneNum, String email) {
    super();
    this.realName = realName;
    this.username = username;
    this.gender = gender;
    this.password = password;
    this.birthdayYear = birthdayYear;
    this.birthdayMonth = birthdayMonth;
    this.birthdayDay = birthdayDay;
    this.phoneNum = phoneNum;
    this.email = email;
  }
  
  /**
   * 用户真实姓名
   */
  private String realName;
  
  /**
   * 用户名
   */
  private String username;
  
  /**
   * 性别（0 女 1男 -1第三性别）
   */
  private int gender;
  
  /**
   * 用户密码
   */
  private String password;
  
  /**
   * 出生日期-年
   */
  private String birthdayYear;
  
  /**
   * 出生日期-月
   */
  private String birthdayMonth;
  
  /**
   * 出生日期-日
   */
  private String birthdayDay;
  
  /**
   * 手机号
   */
  private String phoneNum;
  
  /**
   * 邮箱
   */
  private String email;
  
  /**
   * @return realName
   */
  public String getRealName() {
    return realName;
  }
  
  /**
   * @param realName set realName
   */
  public void setRealName(String realName) {
    this.realName = realName;
  }
  
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
  public int getGender() {
    return gender;
  }
  
  /**
   * @param gender set gender
   */
  public void setGender(int gender) {
    this.gender = gender;
  }
  
  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * @param password set password
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * @return birthdayYear
   */
  public String getBirthdayYear() {
    return birthdayYear;
  }
  
  /**
   * @param birthdayYear set birthdayYear
   */
  public void setBirthdayYear(String birthdayYear) {
    this.birthdayYear = birthdayYear;
  }
  
  /**
   * @return birthdayMonth
   */
  public String getBirthdayMonth() {
    return birthdayMonth;
  }
  
  /**
   * @param birthdayMonth set birthdayMonth
   */
  public void setBirthdayMonth(String birthdayMonth) {
    this.birthdayMonth = birthdayMonth;
  }
  
  /**
   * @return birthdayDay
   */
  public String getBirthdayDay() {
    return birthdayDay;
  }
  
  /**
   * @param birthdayDay set birthdayDay
   */
  public void setBirthdayDay(String birthdayDay) {
    this.birthdayDay = birthdayDay;
  }
  
  /**
   * @return phoneNum
   */
  public String getPhoneNum() {
    return phoneNum;
  }
  
  /**
   * @param phoneNum set phoneNum
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }
  
  /**
   * @return email
   */
  public String getEmail() {
    return email;
  }
  
  /**
   * @param email set email
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
