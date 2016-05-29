/**
 * File：CommonDaoSupport.java
 * Package：com.letus179.commons.dao
 * Author：xfyin
 * Date：2016-5-20 下午9:49:15
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.letus179.commons.bean.PageVO;
import com.letus179.commons.bean.PagedResult;

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
  
  /**
   * 由HibernateTemplate生成一个session，该session使用前需要开启事务，提交事务，使用完后关闭事务。
   * 开启事务的方式：session.beginTransaction();
   * 事务提交：session.getTransaction().commit();
   * 事务关闭：session.close();
   * 
   * @return 返回一个hibernate Session
   */
  public Session getSession() {
    return hibernateTemplate.getSessionFactory().getCurrentSession();
  }
  
  /**
   * 根据构造的查询条件查询数据，并返回总记录数。
   * <b>注：</b>该方法适用需要进行分页的查询场景，返回值{@link ListResult}包含如下内容：
   * <li>data：一个List，表示当前页的记录集。</li>
   * <li>rowCount：满足查询条件的总记录数。</li>
   * 如果不需要进行分页，应该使用{@link CommonDaoSupport#queryByQueryInfo}
   * 
   * @param queryFilter <T> 查询条件，参见{@link HqlQueryFilter}
   * @param <T> 要查询的实体类型
   * @return 查询结果，参见{@link ListResult}。如果没有满足条件的记录，则ListResult中返回空的Lise<T>
   */
  public <T> PagedResult<T> queryList(HqlQueryFilter queryFilter) {
    return hibernateTemplate.execute(new PagedResultCallback<T>(queryFilter));
  }
  
  /**
   * 使用HQL语句查询
   * 
   * @param hqlString  HQL语句
   * @param values  参数
   * @param <T> 要查询的实体类型
   * @return 符合条件的对象列表。如果没有满足条件的记录，则返回空的List<T>。
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> find(String hqlString, Object... values) {
    return (List<T>) hibernateTemplate.find(hqlString, values);
  }
  
  /**
   * 使用HQL语句查询
   * 
   * @param hqlString  HQL语句
   * @param params  参数
   * @param pageVO 分页信息
   * @param <T> 要查询的实体类型
   * @return 符合条件的对象列表。如果没有满足条件的记录，则返回空的List<T>。
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> find(String hqlString, Map<String, Object> params, PageVO pageVO) {
    Query query = this.getSession().createQuery(hqlString);
    if (params != null) {
      for (Map.Entry<String, Object> entry : params.entrySet()) {
        String key = entry.getKey();
        query.setParameter(key, params.get(key));
      }
    }
    if (pageVO != null) {
      query.setFirstResult(pageVO.getOffset());
      query.setMaxResults(pageVO.getLimit());
    }
    return (List<T>) query.list();
  }
  
  /**
   * 使用HQL语句查询
   * 
   * @param hqlString  HQL语句
   * @param values  参数
   * @return 符合条件的对象。如果没有满足条件的记录，则返回空的List<T>。
   */
  public Object uniqueResult(String hqlString, Object... values) {
    Query query = this.getSession().createQuery(hqlString);
    if (values != null) {
      for (int i = 0; i < values.length; i++) {
        query.setParameter(i, values[i]);
      }
    }
    return query.uniqueResult();
  }
  
  /**
   * 使用HQL语句查询
   * 
   * @param hqlString  HQL语句
   * @param params 参数
   * @return 符合条件的对象。如果没有满足条件的记录，则返回null。
   */
  public Object uniqueResult(String hqlString, Map<String, Object> params) {
    Query query = this.getSession().createQuery(hqlString);
    if (params != null) {
      for (Map.Entry<String, Object> entry : params.entrySet()) {
        String key = entry.getKey();
        query.setParameter(key, params.get(key));
      }
    }
    return query.uniqueResult();
  }
  
  /**
   * 增加实体。
   * 
   * @param entity 要增加的实体
   */
  public void insert(Object entity) {
    hibernateTemplate.save(entity);
  }
  
  /**
   * 增加或修改实体。
   * 
   * @param entity 要增加的实体
   */
  public void saveOrUpdate(Object entity) {
    hibernateTemplate.saveOrUpdate(entity);
  }
  
  /**
   * 删除实体。
   * 
   * @param entity 要删除的实体
   */
  public void delete(Object entity) {
    hibernateTemplate.delete(entity);
  }
  
  /**
   * 修改实体。
   * 
   * @param entity 要修改的实体
   */
  public void update(Object entity) {
    hibernateTemplate.update(entity);
  }
  
  /**
   * 更新实体
   * 
   * @param entity 实体
   */
  public void merge(Object entity) {
    hibernateTemplate.merge(entity);
  }
  
  /**
   * 执行一段hql操作（增、删、改）语句
   * 例如： delete from Operator o where o.id = ?
   * update Operator o set o.name = ? where o.id = ?
   * @param hqlString hql操作语句
   * @param values 参数值
   * @return 操作所影响的记录数
   */
  public int execute(String hqlString, Object... values) {
    return hibernateTemplate.bulkUpdate(hqlString, values);
  }
  
  /**
   * 执行一段hql操作（增、删、改）语句
   * 例如： delete from Operator o where o.id = ?
   * update Operator o set o.name = :name where o.id = :id
   * @param hqlString hql操作语句
   * @param params 参数值
   * @return 操作所影响的记录数
   */
  public int execute(String hqlString, Map<String, Object> params) {
    Query query = this.getSession().createQuery(hqlString);
    if (params != null) {
      
      for (Map.Entry<String, Object> entry : params.entrySet()) {
        String key = entry.getKey();
        query.setParameter(key, params.get(key));
      }
    }
    return query.executeUpdate();
  }
}
