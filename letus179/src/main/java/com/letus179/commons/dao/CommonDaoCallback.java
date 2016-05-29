/**
 * File：CommonDaoCallback.java
 * Package：com.letus179.commons.dao
 * Author：xfyin
 * Date：2016-5-25 下午1:12:27
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.util.Collection;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;


/**
 * 通用数据访问Dao回调，实现{@link HibernateCallback}。
 * @param T 要查询的实体类
 * @author xfyin
 */
public class CommonDaoCallback<T> implements HibernateCallback<T> {

  @Override
  public T doInHibernate(Session arg0) throws HibernateException {
    // TODO Auto-generated method stub
    return null;
  }
  /**
   * 查询过滤器
   */
  private HqlQueryFilter queryFilter;
  
  /**
   * 构造方法
   * 
   * @param queryFilter
   *        查询过滤器
   */
  CommonDaoCallback(HqlQueryFilter queryFilter) {
    this.queryFilter = queryFilter;
  }
  
  /**
   * 设置Hql中的命名参数
   * 
   * @param query
   *        query对象
   */
  protected void setParamNameValues(Query query) {
    if (queryFilter.getHqlStr() != null) {
      for (int i = 0; i < getQueryFilter().getValues().size(); i++) {
        Object value = getQueryFilter().getValues().get(i);
        query.setParameter(i, value);
      }
      return;
    }
    for (Entry<String, Object> param : queryFilter.getParamNameValues().entrySet()) {
      String paranName = param.getKey();
      Object paramValue = param.getValue();
      
      if (paramValue instanceof Collection<?>) {
        query.setParameterList(paranName, (Collection<?>) paramValue);
      }
      
      else if (paramValue instanceof Object[]) {
        query.setParameterList(paranName, (Object[]) paramValue);
      }
      
      else {
        query.setParameter(paranName, paramValue);
      }
    }
  }
  
  /**
   * @return queryFilter
   */
  public HqlQueryFilter getQueryFilter() {
    return queryFilter;
  }
}
