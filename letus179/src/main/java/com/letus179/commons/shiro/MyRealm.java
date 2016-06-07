/**
 * File：MyRealm.java
 * Package：com.letus179.commons.shiro
 * Author：xfyin
 * Date：2016-5-24 下午6:50:42
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letus179.commons.dao.ServiceResult;
import com.letus179.commons.entity.User;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;
import com.letus179.util.LS179Logger;
import com.letus179.util.Md5Util;

/**
 * 自定义realm
 * 
 * @author xfyin
 */
@Service("myRealm")
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
    UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
    String username = token.getUsername();
    User user = userService.getUserByUsername(username);
    if (user == null) {
      return null;
    }
    //数据库中的password
    String password = user.getPassword();
    String salt = user.getSalt();
    ActiveUser activeUser = new ActiveUser();
    activeUser.setUserId(user.getId());
    activeUser.setUsername(username);
    activeUser.setRealname(user.getRealName());
    int gender = user.getGender();
    String sex = "";
    if (gender == 1) {
      sex = "先生";
    }else if (gender == 0) {
      sex = "女士";
    } else {
      sex = "同志";
    }
    activeUser.setGender(sex);
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, password,
        ByteSource.Util.bytes(salt), getName());
    
    return info;
  }
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
    return null;
  }
  
  /**
   * 清空缓存
   * 修改了用户的权限，而用户并不立即退出系统，就调用此方法手动清空缓存
   */
  public void clearCached() {
    PrincipalCollection principals =  SecurityUtils.getSubject().getPrincipals();
    super.clearCache(principals);
  }
}
