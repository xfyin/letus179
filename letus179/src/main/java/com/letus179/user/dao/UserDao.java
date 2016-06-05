/**
 * File：UserDao.java
 * Package：com.letus179.user.dao
 * Author：xfyin
 * Date：2016-5-25 下午5:38:24
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.user.dao;

import com.letus179.commons.entity.User;

/**
 * 用户dao
 *
 * @author xfyin
 */
public interface UserDao {
  
  /**
   * 添加用户
   * @param user 用户
   */
  void addUser(User user);
  
  /**
   * 根据用户名获取用户信息
   * @param username 用户名
   * @return User
   */
  User getUserByUsername(String username);
  
  /**
   * 修改用户信息
   * @param user 用户
   */
  void modifyUser(User user);
  
  /**
   * 获取用户数
   * @return 用户数
   */
  long countUser();
  
  /**
   * 根据info获取登录信息
   * @param info username||phone||email
   * @return User
   */
  User getUserByInfo(String info);
}
