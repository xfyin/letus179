/**
 * File：LoginController.java
 * Package：com.letus179.commons.login.controller
 * Author：xfyin
 * Date：2016-5-24 下午7:05:41
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.letus179.commons.dao.ServiceException;
import com.letus179.commons.dao.ServiceResult;
import com.letus179.commons.entity.Statisticalaccess;
import com.letus179.commons.entity.User;
import com.letus179.commons.shiro.MyRealm;
import com.letus179.statistical.statisticalAccess.service.StatisticalAccessService;
import com.letus179.user.bean.ActiveUser;
import com.letus179.user.service.UserService;
import com.letus179.util.LS179Logger;
import com.letus179.util.SpringBeanUtils;
import com.letus179.util.StringUtils;
import com.letus179.util.WebUtils;

/**
 * 用户登录
 * 
 * @author xfyin
 */
@Controller
public class LoginController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private StatisticalAccessService statisticalAccessService;
  
  /**
   * 跳转到登录页面
   * @return 登录页面
   */
  @RequestMapping("/main")
  public String main() {
    return "login";
  }
/*  
  @RequestMapping("/login")
  public String loginFailure(HttpServletRequest request) throws Exception {
    //若登录失败，从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
    String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
    if (StringUtils.isNotBlank(exceptionClassName)) {
      if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
        LS179Logger.warn("账号不存在");
        throw new ServiceException(new ServiceResult("账号不存在"));
      }
      else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
        LS179Logger.warn("用户名或密码错误");
        throw new ServiceException(new ServiceResult("用户名或密码错误"));
      }
      else {
        LS179Logger.warn("unknow error!");
        throw new Exception("unknow error!");
      }
    }
    //此方法不处理登录成功，shiro认证成功将自动跳到上一个请求路径
    //若登录失败，跳回login页面
    return "login";
  }*/
  
  /**
   * 用户登录
   * @param request
   * @param response
   * @return 首页
   */
  @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
  public String loginCheck(HttpServletRequest request, HttpServletResponse response,Model model) {
    request.getSession().removeAttribute("Msg");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    token.setRememberMe(false);
    //userInfo 或者为username||phone||email
    String userInfo = token.getUsername();
    String realName = "";
    try {
      realName = userService.getUserByInfo(userInfo).getRealName();
    }
    catch (Exception e) {
      
      LS179Logger.error(e.getMessage());
      return "redirect:main.do";
    }
    request.getSession().setAttribute("realname", realName);
    Subject currentUser = SecurityUtils.getSubject();
    try {
      currentUser.login(token);
    }
    catch (AuthenticationException e) {
      model.addAttribute("Msg", e.getMessage());
      return "login";
    }
    return "redirect:welcome.do";
  }
  
  /**
   * 跳转到欢迎页面
   * @param request 请求
   * @param response 响应
   * @return ModelAndView
   */
  @RequestMapping("/welcome")
  public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
    //重新加载一次权限
    reLoadAuth();
    
    //获取权限信息 List<Resource>
    /**
     * List<Resource> lists= .queryAllResourceByLoginName(WebUtils
     *      .getCurrentUserName());
     *       
     */
    ActiveUser userinfo = (ActiveUser) WebUtils.getCurrentUserInfo();
    //访问统计
    Statisticalaccess access = statisticalAccessService.getAccessByUserId(userinfo.getUserId());
    //获取总访问量
    long visits = statisticalAccessService.countVisitTimes();
    access.setLiveness((double) (access.getVisitTimes() + 1) / ((int) visits + 1));
    access.setUpdateTime(new Date());
    access.setVisitTimes(access.getVisitTimes() + 1);
    statisticalAccessService.updateAccess(access);
    
    ModelAndView mv = new ModelAndView("welcome");
    mv.addObject("activeUser",  userinfo);
    return mv;
  }
  
  /**
   *  重装加载用户权限
   */
  private void reLoadAuth() {
    Object shiroBean = SpringBeanUtils.getBean("myRealm");
    MyRealm myRealm = (MyRealm) shiroBean;
    if (myRealm != null) {
      myRealm.onLogout(SecurityUtils.getSubject().getPrincipals());
      myRealm.isPermitted(SecurityUtils.getSubject().getPrincipals(), "强制shiro检查加载用户权限缓存，避免懒加载  "
          + System.currentTimeMillis());
    }
  }
  
  /**
   * 获取登录超时时间，供页面上倒计时使用
   * 
   * @param req
   *        req
   * @return result
   */
  /*@RequestMapping("/getTimeOut")
  @ResponseBody
  public CtResult getTimeOut(HttpServletRequest req) {
    String address = "com/fang/bdp/core/conf/constants/constants.properties";
    String timeOut = PropertiesReaderUtils.getProperties(address, "timeout");
    if ("timeout".equals(timeOut)) {
      timeOut = "7200000";
    }
    return CtResult.success(timeOut);
  }*/
  
  
}
