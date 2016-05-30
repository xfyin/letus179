/**
 * File：MainController.java
 * Package：com.letus179.commons.main
 * Author：xfyin
 * Date：2016-5-25 下午5:23:24
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.index;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letus179.user.bean.ActiveUser;

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
    /*Subject subject = SecurityUtils.getSubject();
    ActiveUser user = (ActiveUser) subject.getPrincipal();*/
    /*model.addAttribute("user", user);*/
    String username = request.getParameter("username");
    model.addAttribute("username", username);
    return "index";
  }
  
  //欢迎页面
  @RequestMapping("/welcome")
  public String welcome(Model model) {
    return "welcome";
  }
}
