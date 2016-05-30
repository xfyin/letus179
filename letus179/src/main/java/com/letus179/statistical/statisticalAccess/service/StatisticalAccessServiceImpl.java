/**
 * File：StatisticalAccessServiceImpl.java
 * Package：com.letus179.statistical.statisticalAccess.service
 * Author：xfyin
 * Date：2016-5-30 下午6:20:50
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.statistical.statisticalAccess.service;

import com.letus179.commons.entity.Statisticalaccess;
import com.letus179.statistical.statisticalAccess.dao.StatisticalAccessDao;
import com.letus179.util.LS179Logger;
import com.letus179.util.StringUtils;


/**
 * service实现
 *
 * @author xfyin
 */
public class StatisticalAccessServiceImpl implements StatisticalAccessService {
  
  private StatisticalAccessDao statisticalAccessDao;
  
  /**
   * @param statisticalAccessDao set statisticalAccessDao
   */
  public void setStatisticalAccessDao(StatisticalAccessDao statisticalAccessDao) {
    this.statisticalAccessDao = statisticalAccessDao;
  }

  @Override
  public Statisticalaccess getAccessByUsername(String username) {
    if (StringUtils.isBlank(username)) {
      LS179Logger.error("用户名为空");
      throw new RuntimeException("用户名为空");
    }
    return statisticalAccessDao.getAccessByUsername(username);
  }
  
  @Override
  public long countVisitTimes() {
    return statisticalAccessDao.countVisitTimes();
  }
  
  @Override
  public void saveAccess(Statisticalaccess access) {
    if (access == null) {
      LS179Logger.error("用户访问信息不存在,插入失败");
      throw new RuntimeException("用户访问信息不存在,插入失败");
    }
    statisticalAccessDao.saveAccess(access);
  }
  
  @Override
  public void updateAccess(Statisticalaccess access) {
    if (access == null) {
      LS179Logger.error("用户访问信息不存在,更新失败");
      throw new RuntimeException("用户访问信息不存在,更新失败");
    }
    statisticalAccessDao.updateAccess(access);
  }
  
}
