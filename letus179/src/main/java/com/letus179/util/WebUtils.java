/**
 * File：WebUtils.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-6-4 下午9:25:59
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;

/**
 * 主要用来：
 * 1、获取当前登录用户名
 * 2、获取当前用户登录IP
 * 3、获取项目名，如letus179
 *
 * @author xfyin
 */
public final class WebUtils {
  
  /**
   * 私有
   */
  private WebUtils() {
  };
  
  /**
   * 获取工程名：如"localhost:8080/letus179/index.do"，对应工程名为letus179
   * @return 工程名
   */
  public static String getProjectName() {
    ApplicationContext context = SpringBeanUtils.getContext();
    if (context != null) {
      return context.getApplicationName();
    }
    else {
      LS179Logger.error("get project name error : be sure spring started and started sucessfully!");
      return "";
    }
  }
  
  /**
   * 获取当前用户名
   * @return 当前用户名
   */
  public static Object getCurrentUserInfo() {
    Subject currentUser = SecurityUtils.getSubject();
    if (currentUser == null) {
      return "anno";
    }
    Object prin =  currentUser.getPrincipal();
    if (prin != null) {
      return prin;
    }
    else {
      return "anno";
    }
  }
  /**
   * 获取当前登录的用户登录IP地址。
   * @return 登录IP地址
   */
  public static String getCurrentUserIp() {
    Subject currentUser = SecurityUtils.getSubject();
    if (currentUser == null) {
      return "unkonw";
    }
    //false如果当前没有创建Session则返回null,true表示如果当前没有创建Session对象会创建一个
    Session session = currentUser.getSession(false);
    if (session != null) {
      return session.getHost();
    } else {
      return "unkonw";
    }
    
  }
  
}
