/**
 * File：LoginController.java
 * Package：com.letus179.commons.login.controller
 * Author：xfyin
 * Date：2016-5-24 下午7:05:41
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.login.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letus179.commons.dao.ServiceException;
import com.letus179.commons.dao.ServiceResult;
import com.letus179.commons.entity.Statisticalaccess;
import com.letus179.commons.entity.User;
import com.letus179.statistical.statisticalAccess.service.StatisticalAccessService;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;
import com.letus179.util.StringUtils;


/**
 * 用户登录
 * 
 * @author xfyin
 */
@Controller
@RequestMapping("/login")
public class LoginController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private StatisticalAccessService statisticalAccessService;
  
  @RequestMapping("/autoLogin")
  public ModelAndView login(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView("welcome");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    //校验用户信息，校验通过后将用户信息返回
    ActiveUser activeUser = userService.authenticat(username, password);
    modelAndView.addObject("user", activeUser);
    
    //访问统计
    User user = userService.getUserByUsername(username);
    Statisticalaccess access = statisticalAccessService.getAccessByUserId(user.getId());
    //获取总访问量
    long visits = statisticalAccessService.countVisitTimes();
    access.setLiveness((double)(access.getVisitTimes()+1)/((int)visits+1));
    access.setUpdateTime(new Date());
    access.setVisitTimes(access.getVisitTimes()+1);
    statisticalAccessService.updateAccess(access);
    return modelAndView;
  }
  
  @RequestMapping("/loginFailure")
  public String loginFailure(HttpServletRequest request) throws Exception {
    //若登录失败，从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
    String exceptionClassName = request.getParameter("shiroLoginFailure");
    if (StringUtils.isNotBlank(exceptionClassName)) {
      if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
        throw new ServiceException(new ServiceResult("账号不存在"));
      } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
        throw new ServiceException(new ServiceResult("用户名或密码错误"));
      } else {
        throw new Exception("unknow error!");
      }
    }
    //此方法不处理登录成功，shiro认证成功将自动跳到上一个请求路径
    //若登录失败，跳回login页面
    return "/login";
  }
  
  
  
  
}
