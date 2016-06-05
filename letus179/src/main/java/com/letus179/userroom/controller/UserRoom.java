/**
 * File：UserRoom.java
 * Package：com.letus179.userroom.controller
 * Author：xfyin
 * Date：2016-6-1 下午11:48:15
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.userroom.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letus179.user.bean.ActiveUser;


/**
 * 用户进入个人空间
 *
 * @author xfyin
 */
@Controller
@RequestMapping("/userroom")
public class UserRoom {
  
  @RequestMapping("/main")
  public String enterRoom(HttpServletRequest request,Model model) {
    ActiveUser user = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
    model.addAttribute("user", user);
    return "pages/userroom";
  }
}
