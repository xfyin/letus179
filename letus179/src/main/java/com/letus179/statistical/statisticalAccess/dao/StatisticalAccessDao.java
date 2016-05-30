/**
 * File：StatisticalAccessDao.java
 * Package：com.letus179.statistical.statisticalAccess.dao
 * Author：xfyin
 * Date：2016-5-30 下午5:58:37
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.statistical.statisticalAccess.dao;

import com.letus179.commons.entity.Statisticalaccess;


/**
 * 用户访问统计dao
 *
 * @author xfyin
 */
public interface StatisticalAccessDao {
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
