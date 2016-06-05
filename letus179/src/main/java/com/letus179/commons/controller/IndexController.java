/**
 * File：MainController.java
 * Package：com.letus179.commons.main
 * Author：xfyin
 * Date：2016-5-25 下午5:23:24
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letus179.user.bean.ActiveUser;
import com.letus179.util.WebUtils;

/**
 * 首页/欢迎页面
 *
 * @author xfyin
 */
@Controller
@RequestMapping("/index")
public class IndexController {
  
  //系统首页
  @RequestMapping("/index")
  public String index(HttpServletRequest request,Model model) {
    Object userinfo = WebUtils.getCurrentUserInfo();
    model.addAttribute("activeUser", userinfo);
    return "index";
  }
  
}
