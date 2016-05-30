/**
 * File：StatisticalAccessDaoImpl.java
 * Package：com.letus179.statistical.statisticalAccess.dao
 * Author：xfyin
 * Date：2016-5-30 下午6:13:22
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.statistical.statisticalAccess.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.letus179.commons.dao.CommonDaoSupport;
import com.letus179.commons.entity.Statisticalaccess;

/**
 * dao实现
 *
 * @author xfyin
 */
public class StatisticalAccessDaoImpl implements StatisticalAccessDao {
  
  private CommonDaoSupport commonDaoSupport;
  
  /**
   * @param commonDaoSupport set commonDaoSupport
   */
  public void setCommonDaoSupport(CommonDaoSupport commonDaoSupport) {
    this.commonDaoSupport = commonDaoSupport;
  }
  
  @Override
  public Statisticalaccess getAccessByUsername(String username) {
    String hql = "from Statisticalaccess where username = :username";
    return (Statisticalaccess) commonDaoSupport.getSession().createQuery(hql)
        .setString("username", username).uniqueResult();
  }
  
  @Override
  public long countVisitTimes() {
    String hql = "select sum(visitTimes) from Statisticalaccess";
    return (long) commonDaoSupport.getSession().createQuery(hql).list().get(0);
  }
  
  @Override
  public void saveAccess(Statisticalaccess access) {
    Session session = commonDaoSupport.getSession();
    Transaction transaction = session.beginTransaction();
    commonDaoSupport.getSession().save(access);
    session.flush();
    transaction.commit();
  }
  
  @Override
  public void updateAccess(Statisticalaccess access) {
    commonDaoSupport.update(access);
  }
  
}
