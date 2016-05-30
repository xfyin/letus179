/**
 * File：UserServiceImpl.java
 * Package：com.letus179.user.service
 * Author：xfyin
 * Date：2016-5-25 下午5:45:49
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.user.service;

import com.letus179.commons.dao.ServiceException;
import com.letus179.commons.dao.ServiceResult;
import com.letus179.commons.entity.User;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.dao.UserDao;
import com.letus179.util.LS179Logger;
import com.letus179.util.Md5Util;
import com.letus179.util.StringUtils;

/**
 * 有关用户操作
 *
 * @author xfyin
 */
public class UserServiceImpl implements UserService {
  
  /**
   * userDao
   */
  private UserDao userDao;
  
  /**
   * @param userDao set userDao
   */
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
  
  @Override
  public void addUser(User user) {
    ServiceResult result = new ServiceResult("添加用户信息");
    if (user == null) {
      LS179Logger.error("user info is null, please check!");
      result.setErrorMsg("user info is null, please check!");
      throw new ServiceException(result);
    }
    userDao.addUser(user);
  }
  
  @Override
  public User getUserByUsername(String username) {
    ServiceResult result = new ServiceResult("根据用户名获取用户信息");
    if (StringUtils.isBlank(username)) {
      LS179Logger.error("username is null, please check!");
      result.setErrorMsg("username is null, please check!");
      throw new ServiceException(result);
    }
    return userDao.getUserByUsername(username);
  }
  
  @Override
  public void modifyUser(User user) {
    ServiceResult result = new ServiceResult("更新用户信息");
    if (user == null) {
      LS179Logger.error("user info is null, please check!");
      result.setErrorMsg("user info is null, please check!");
      throw new ServiceException(result);
    }
    userDao.modifyUser(user);
  }
  
  @Override
  public ActiveUser authenticat(String username, String password) {
    ServiceResult result = new ServiceResult("用户登入认证");
    User user = this.getUserByUsername(username);
    if (user == null) {
      LS179Logger.error("根据用户名不能找到该用户信息，username：" + username);
      result.setErrorMsg("根据用户名不能找到该用户信息，username：" + username);
      throw new ServiceException(result);
    }
    String pwdDB = user.getPassword();
    int salt = user.getSalt();
    
    if (StringUtils.isBlank(password)) {
      LS179Logger.error("用户输入的密码为空，不符合认证规则");
      result.setErrorMsg("用户输入的密码为空，不符合认证规则");
      throw new ServiceException(result);
    }
    
    //将用户输入的密码用md5加密+盐后与数据库存的密码对比
    String pwd = Md5Util.md5(password, salt);
    if (!pwd.equals(pwdDB)) {
      LS179Logger.error("用户名或密码错误");
      result.setErrorMsg("用户名或密码错误");
      throw new ServiceException(result);
    }
    
    //将需要的用户信息封装在ActiveUser中返回
    //0 女 1男 -1第三性别
    String sex = "";
    int gender = user.getGender();
    if (gender == 0) {
      sex = "女士";
    } else if (gender == 1) {
      sex = "先生";
    } else {
      sex = "同志";
    }
    ActiveUser activeUser = new ActiveUser();
    activeUser.setUsername(username);
    activeUser.setGender(sex);
    return activeUser;
  }

  @Override
  public long countUser() {
    return userDao.countUser();
  }
  
}
