/**
 * File：SortVO.java
 * Package：com.letus179.commons.bean
 * Author：xfyin
 * Date：2016-5-25 下午12:42:28
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.bean;

import com.letus179.util.StringUtils;

/**
 * 排序
 *
 * @author xfyin
 */
public class SortVO {
  
  /**
   * 排序方式ASC
   */
  public static final String ASC = "ASC";
  
  /**
   * 排序方式DESC
   */
  public static final String DESC = "DESC";
  
  /**
   * 排序列名称
   */
  private String sort;
  
  /**
   * asc或desc
   */
  private String order;
  
  /**
   * @return sort
   */
  public String getSort() {
    return sort;
  }
  
  /**
   * 防止sql注入 包含非法字符的string不能被set
   * <p>
   * 非法字符请参考{@link com.fang.bdp.core.util.StringUtils StringUtils}.ILLAGAL_SQL数组
   * <p>
   * 但","除外，因为多列排序需要用到
   * 
   * @param sort
   *        set sort
   */
  public void setSort(String sort) {
    if (sort != null) {
      // 防止sql注入 替换“,”是因为多列排序时需要用到“,”
      String sortTemp = sort.replaceAll(",", "");
      sortTemp = StringUtils.checkValidSQL(sortTemp);
      if (sortTemp == null) {
        this.sort = null;
        return;
      }
    }
    this.sort = sort;
  }
  
  /**
   * @return order
   */
  public String getOrder() {
    return order;
  }
  
  /**
   * 防止sql注入 包含非法字符的string不能被set
   * <p>
   * 非法字符请参考{@link com.fang.bdp.core.util.StringUtils StringUtils}.ILLAGAL_SQL数组
   * <p>
   * 但","除外，因为多列排序需要用到
   * 
   * @param order
   *        set order
   */
  public void setOrder(String order) {
    // 防止sql注入
    if (order != null) {
      // 防止sql注入 替换“,”是因为多列排序时需要用到“,”
      String orderTemp = order.replaceAll(",", "");
      orderTemp = StringUtils.checkValidSQL(orderTemp);
      if (orderTemp == null) {
        this.order = null;
        return;
      }
    }
    this.order = order;
  }
}
