/**
 * File：MyRealm.java
 * Package：com.letus179.commons.shiro
 * Author：xfyin
 * Date：2016-5-24 下午6:50:42
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.letus179.commons.dao.ServiceResult;
import com.letus179.commons.entity.User;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;
import com.letus179.util.LS179Logger;

/**
 * 自定义realm
 * 
 * @author xfyin
 */
public class MyRealm extends AuthorizingRealm {
  
  @Autowired
  private UserService userService;
  
  @Override
  public void setName(String name) {
    super.setName("myRealm");
  }
  
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    ServiceResult result = new ServiceResult("用户认证中...");
    UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
    String username = token.getUsername();
    User user = userService.getUserByUsername(username);
    if (user == null) {
      LS179Logger.error("用户：" + username + " 的用户信息不存在");
      result.setErrorMsg("用户：" + username + " 的用户信息不存在");
      throw new RuntimeException();
    }
    //数据库中的password
    String password = user.getPassword();
    int salt = user.getSalt();
    ActiveUser activeUser = new ActiveUser();
    
    activeUser.setUsername(username);
    
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, password,
        ByteSource.Util.bytes(salt), getName());
    
    return info;
  }
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    principals.getPrimaryPrincipal();
    // TODO Auto-generated method stub
    return null;
  }
  
  
}
