/**
 * File：SpringBeanUtils.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-6-4 下午9:28:21
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 *
 * @author xfyin
 */
public class SpringBeanUtils {
  
  /**
   * 配置文件目录
   */
  private static String[] locations = {"META-INF/spring/spring-root.xml"};
  
  /**
   * spring上下文  
   */
  private static ApplicationContext context = new ClassPathXmlApplicationContext(locations);
  
  /**
   * 获取springContext管理的Bean
   * 如：UserService userService = SpringBeanUtils.getBean("userService");
   * @param beanName 类名
   * @return 类
   */
  public static Object getBean(String beanName) {
    return context.getBean(beanName);
  }
  
  /**
   * 获取springContext管理的Bean
   * 如：UserService userService = SpringBeanUtils.getBean("userService",UserService.class);
   * @param <T>
   * @param beanName 类名
   * @return 类
   */
  public static <T> T getBean(String beanName, Class<T> type) {
    return context.getBean(beanName, type);
  }
  
  /**
   * @return context
   */
  public static ApplicationContext getContext() {
    return context;
  }
}
