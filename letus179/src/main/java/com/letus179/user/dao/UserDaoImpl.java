/**
 * File：UserDaoImpl.java
 * Package：com.letus179.user.dao
 * Author：xfyin
 * Date：2016-5-25 下午5:39:29
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.letus179.commons.dao.CommonDaoSupport;
import com.letus179.commons.entity.User;

/**
 * 用户dao实现
 *
 * @author xfyin
 */
public class UserDaoImpl implements UserDao {
  
  /**
   * 注入commonDaoSupport
   */
  private CommonDaoSupport commonDaoSupport;
  
  /**
   * @return commonDaoSupport
   */
  public CommonDaoSupport getCommonDaoSupport() {
    return commonDaoSupport;
  }
  
  /**
   * @param commonDaoSupport set commonDaoSupport
   */
  public void setCommonDaoSupport(CommonDaoSupport commonDaoSupport) {
    this.commonDaoSupport = commonDaoSupport;
  }
  
  @Override
  public void addUser(User user) {
    Session session = commonDaoSupport.getSession();
    Transaction tx = session.beginTransaction();
    commonDaoSupport.getSession().save(user);
    session.flush();
    tx.commit();
    
  }
  
  @Override
  public User getUserByUsername(String username) {
    String hql = "from User where username = :username";
    return (User) commonDaoSupport.getSession().createQuery(hql).setString("username", username)
        .uniqueResult();
  }
  
  @Override
  public void modifyUser(User user) {
    commonDaoSupport.update(user);
  }
  
}
