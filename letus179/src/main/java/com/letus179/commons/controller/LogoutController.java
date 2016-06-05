/**
 * File：LogoutController.java
 * Package：com.letus179.commons.logout.controller
 * Author：xfyin
 * Date：2016-5-30 下午10:15:43
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letus179.commons.entity.Statisticalaccess;
import com.letus179.commons.entity.User;
import com.letus179.statistical.statisticalAccess.service.StatisticalAccessService;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;

/**
 * 退出登录
 *
 * @author xfyin
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
  
  @Autowired
  private StatisticalAccessService statisticalAccessService;
  
  @RequestMapping("/logout")
  public String logout(HttpServletRequest request) {
    Subject curr = SecurityUtils.getSubject();
    ActiveUser user = (ActiveUser) curr.getPrincipal();
    Statisticalaccess access = statisticalAccessService.getAccessByUserId(user.getUserId());
    access.setLastVisitTime(new Date());
    statisticalAccessService.updateAccess(access);
    curr.logout();
    return "index";
  }
}
