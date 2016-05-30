/**
 * File：RegisterController.java
 * Package：com.letus179.commons.register.controller
 * Author：xfyin
 * Date：2016-5-28 下午3:27:57
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.register.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letus179.commons.entity.Statisticalaccess;
import com.letus179.commons.entity.User;
import com.letus179.statistical.statisticalAccess.service.StatisticalAccessService;
import com.letus179.user.service.UserService;
import com.letus179.util.DateCalculate;
import com.letus179.util.LS179Logger;
import com.letus179.util.Md5Util;
import com.letus179.util.RandomUtil;
import com.letus179.util.StringUtils;

/**
 * 用户注册
 *
 * @author xfyin
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private StatisticalAccessService statisticalAccessService;
  
  /**
   * 用户注册
   * @param request 请求信息
   * @return 注册成功
   */
  @RequestMapping("/register")
  public String register(HttpServletRequest request) {
    String realName = request.getParameter("realname");
    String username = request.getParameter("username");
    String gender = request.getParameter("sex");
    String password = request.getParameter("pwd");
    String birthdayYear = request.getParameter("b_year");
    String birthdayMonth = request.getParameter("b_month");
    String birthdayDay = request.getParameter("b_day");
    String phoneNum = request.getParameter("phone");
    String email = request.getParameter("email");
    String province = request.getParameter("province");
    String city = request.getParameter("city");
    String district = request.getParameter("district");
    User user = new User();
    Statisticalaccess access = new Statisticalaccess();
    //获取用户总数
    long count = userService.countUser();
    Date occur = new Date();
    
    access.setId(StringUtils.get32UUID());
    access.setNumber((int)count+1);
    access.setVisitTimes(0);
    //退出的时候记录最后访问时间
    access.setLastVisitTime(occur);
    access.setLiveness(0);
    access.setCreateTime(occur);
    access.setUpdateTime(occur);
    
    user.setId(StringUtils.get32UUID());
    user.setRealName(realName);
    user.setUsername(username);
    user.setGender(Integer.valueOf(gender));
    int salt = RandomUtil.getSalt(1, 10000);
    user.setSalt(salt);
    user.setPassword(Md5Util.md5(password, salt));
    user.setPhone(phoneNum);
    user.setEmail(email);
    user.setProvince(province);
    user.setCity(city);
    user.setDistrict(district);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date birthday = null;
    try {
      birthday = format.parse(birthdayYear + "-" + birthdayMonth + "-" + birthdayDay);
      user.setBirthday(birthday);
    }
    catch (ParseException e) {
      LS179Logger.error(e + "日期格式转换错误");
      return "";
    }
    user.setAge(DateCalculate.getAgeByBirthday(birthday));
    user.setCreateTime(occur);
    user.setUpdateTime(occur);
    access.setUser(user);
    statisticalAccessService.saveAccess(access);
    HttpSession session = request.getSession();
    session.setAttribute("success", "恭喜您，注册成功，让我们一起走吧！");
    return "index";
  }
}
