/**
 * File：MyShiroFilter.java
 * Package：com.letus179.commons.shiro
 * Author：xfyin
 * Date：2016-6-4 下午12:22:49
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.shiro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.DelegatingFilterProxy;


/**
 * 自定义ShiroFilter
 *
 * @author xfyin
 */
public class MyShiroFilter extends DelegatingFilterProxy{
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    if (!(request instanceof HttpServletRequest)) {
      super.doFilter(request, response, chain);
      return;
    }
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    String url = httpRequest.getRequestURL().toString();
    
    //由于Resin等服务器原因，如果用户已经登录，这时服务器重启，再次刷新页面时由于之前的SessionID已经不存在于Server上，
    //这样会重新生成一个新的SessionID,此时新的SessionID也不存在于Shiro中，因此进行了Redirect来规避这个问题。
    if(url.contains("login.jsp;JSESSIONID")) {
      httpResponse.sendRedirect("login.jsp");
      return;
    }
    super.doFilter(request , response, chain);
  }
}
