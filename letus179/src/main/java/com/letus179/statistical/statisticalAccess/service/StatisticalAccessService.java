/**
 * File：StatisticalAccessService.java
 * Package：com.letus179.statistical.statisticalAccess.service
 * Author：xfyin
 * Date：2016-5-30 下午5:59:01
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.statistical.statisticalAccess.service;

import com.letus179.commons.entity.Statisticalaccess;

/**
 * 用户访问统计
 *
 * @author xfyin
 */
public interface StatisticalAccessService {
  
  /**
   * 根据用户名获取用户访问情况
   * @param username 用户名
   * @return 用户访问
   */
  Statisticalaccess getAccessByUsername(String username);
  
  /**
   * 统计总访问次数
   * 
   * @return 总访问次数
   */
  long countVisitTimes();
  
  /**
   * 保存统计数据
   * @param access 访问数据
   */
  void saveAccess(Statisticalaccess access);
  
  /**
   * 更新访问数据
   * @param access 访问数据
   */
  void updateAccess(Statisticalaccess access);
}
