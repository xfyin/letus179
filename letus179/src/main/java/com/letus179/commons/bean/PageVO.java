/**
 * File：PageVO.java
 * Package：com.letus179.commons.bean
 * Author：xfyin
 * Date：2016-5-25 下午12:38:56
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.bean;

/**
 * 分页因子
 *
 * @author xfyin
 */
public class PageVO {
  
  /**
   * 查询多少个
   */
  private int limit;
  
  /**
   * 从第几个开始查
   */
  private int offset;
  
  /**
   * @return limit
   */
  public int getLimit() {
    return limit;
  }
  
  /**
   * @param limit
   *        set limit
   */
  public void setLimit(int limit) {
    this.limit = limit;
  }
  
  /**
   * @return offset
   */
  public int getOffset() {
    return offset;
  }
  
  /**
   * @param offset
   *        set offset
   */
  public void setOffset(int offset) {
    this.offset = offset;
  }
  
  @Override
  public String toString() {
    //limit=0表示没有传值，不分页
    if (limit == 0) {
      return "";
    }
    return "从第" + this.offset + "个开始,查询" + this.limit + "个";
  }
}
