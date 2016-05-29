/**
 * File：PagedResult.java
 * Package：com.letus179.commons.bean
 * Author：xfyin
 * Date：2016-5-25 下午12:36:52
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.bean;

import java.util.List;

/**
 * bootstrap-Table 返回页面的对象
 *
 * @author xfyin
 */
public class PagedResult<T> {
  
  /**
   * 记录总数
   */
  private long total;
  
  /**
   * 值
   */
  private List<T> rows;
  
  /**
   * 附带参数
   */
  private Object data;
  
  /**
   * 空构造函数
   */
  public PagedResult() {
    super();
  }
  
  /**
   * 构造函数
   * @param total 总数
   * @param rows 数据
   */
  public PagedResult(long total, List<T> rows) {
    this.rows = rows;
    this.total = total;
  }
  
  /**
   * @return total
   */
  public long getTotal() {
    return total;
  }
  
  /**
   * @param total
   *        set total
   */
  public void setTotal(long total) {
    this.total = total;
  }
  
  /**
   * @return rows
   */
  public List<T> getRows() {
    return rows;
  }
  
  /**
   * @param rows
   *        set rows
   */
  public void setRows(List<T> rows) {
    this.rows = rows;
  }
  
  /**
   * @return data
   */
  public Object getData() {
    return data;
  }
  
  /**
   * @param data set $paramName
   */
  public void setData(Object data) {
    this.data = data;
  }
  
}
