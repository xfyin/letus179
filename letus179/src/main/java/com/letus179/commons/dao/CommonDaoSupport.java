/**
 * File：CommonDaoSupport.java
 * Package：com.letus179.commons.dao
 * Author：xfyin
 * Date：2016-5-20 下午9:49:15
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;


/**
 * 通用数据访问支持，用于提供基本的数据库增删改查等功能。
 * 所有的数据访问层（Dao）实现类中，应该注入该类并使用其提供的接口，完成相应的数据库操作
 *
 * @author xfyin
 */
public class CommonDaoSupport {
  
  /**
   * hibernateTemplate
   */
  private HibernateTemplate hibernateTemplate;

  
  /**
   * @param hibernateTemplate set hibernateTemplate
   */
  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }
  
}
