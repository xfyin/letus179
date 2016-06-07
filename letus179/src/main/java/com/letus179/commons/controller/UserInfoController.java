/**
 * File：ForgetpasswordController.java
 * Package：com.letus179.commons.controller
 * Author：xfyin
 * Date：2016-6-5 下午11:16:30
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.letus179.commons.entity.User;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;
import com.letus179.util.Md5Util;
import com.letus179.util.RandomUtil;

/**
 * 用户信息修改
 *
 * @author xfyin
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
  
  @Autowired
  private UserService userService;
  
  /**
   * 用户修改密码
   * @param request 请求信息
   * @param model 返回数据
   * @return 返回页面
   */
  @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
  public String modifyPwd(HttpServletRequest request, Model model) {
    Subject currUser = SecurityUtils.getSubject();
    ActiveUser activeUser = (ActiveUser) currUser.getPrincipal();
    User user = userService.getUserByUsername(activeUser.getUsername());
    String newPwd = request.getParameter("password");
    String salt = RandomUtil.getSalt(1, 10000);
    user.setPassword(Md5Util.md5(newPwd, salt));
    userService.modifyUser(user);
    model.addAttribute("pwdMsg", "修改密码成功");
    return "password";
  }
  
  /**
   * 用户信息修改
   * @param request 请求信息
   * @param model 返回数据
   * @return 返回页面
   */
  @RequestMapping(value = "/modifyBaseInfo", method = RequestMethod.POST)
  public String modifyUserInfo(HttpServletRequest request, Model model) {
    
    
    return null;
    
  }
  
  
  
}
