/**
 * File：SearchController.java
 * Package：com.letus179.search.controller
 * Author：xfyin
 * Date：2016-5-29 下午8:51:03
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * lucene实现的检索
 *
 * @author xfyin
 */
@Controller
@RequestMapping("/search")
public class SearchController {
  
  @RequestMapping("/search")
  public ModelAndView search(HttpServletRequest request) {
    
    ModelAndView modelAndView = new ModelAndView();
    
    return modelAndView;
  }
}
