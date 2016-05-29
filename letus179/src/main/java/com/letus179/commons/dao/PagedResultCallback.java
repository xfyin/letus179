/**
 * File：PagedResultCallback.java
 * Package：com.letus179.commons.dao
 * Author：xfyin
 * Date：2016-5-25 下午1:15:58
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.letus179.commons.bean.PagedResult;


/**
 * 用于返回分页ListResult查询结果的回调
 *
 * @author xfyin
 */
public class PagedResultCallback<T> extends CommonDaoCallback<PagedResult<T>>{
  /**
   * 构造方法
   * 
   * @param queryFilter
   *        查询过滤器
   */
  PagedResultCallback(HqlQueryFilter queryFilter) {
    super(queryFilter);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings({"unchecked", "rawtypes" })
  public PagedResult<T> doInHibernate(Session session) {
    HqlQueryFilter queryFilter = getQueryFilter();
    Query queryRecord = session.createQuery(queryFilter.getQueryString());
    DetachedCriteria detachedCriteria = queryFilter.getDetachedCriteria();
    // 如果detachedCriteria不为空则使用criteria查询，否则使用queryFilter查询
    if (null != detachedCriteria) {
      // 根据detachedCriteria获得criteria对象
      // 分页信息
      Criteria criteria = detachedCriteria.getExecutableCriteria(session);
      if ((queryFilter.getStartRowIndex() != -1) && (queryFilter.getRowCountPerPage() != -1)) {
        criteria.setFirstResult(queryFilter.getStartRowIndex());
        criteria.setMaxResults(queryFilter.getRowCountPerPage());
      }
      
      criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
      List<?> result = criteria.list();
      // 获取符合条件的对象的总条数，即select count(*) from ....
      long totalCount = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult())
          .longValue();
      return new PagedResult(totalCount, result);
    }
    
    setParamNameValues(queryRecord);
    
    if ((queryFilter.getStartRowIndex() != -1) && (queryFilter.getRowCountPerPage() != -1)) {
      queryRecord.setFirstResult(queryFilter.getStartRowIndex());
      queryRecord.setMaxResults(queryFilter.getRowCountPerPage());
    }
    
    List<T> result = queryRecord.list();
    
    Query queryTotalCount = session.createQuery(queryFilter.getQueryTotalCountString());
    
    setParamNameValues(queryTotalCount);
    
    Number totalCount = (Number) queryTotalCount.uniqueResult();
    
    return new PagedResult<T>(totalCount.longValue(), result);
  }
}
