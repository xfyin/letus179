/**
 * File：ServiceResult.java
 * Package：com.letus179.commons.service
 * Author：xfyin
 * Date：2016-5-24 下午7:23:07
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.io.Serializable;

/**
 * service层操作结果
 *
 * @author xfyin
 */
public class ServiceResult implements Serializable {
  
  /**
   * 序列号
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * 描述
   */
  private String desc;
  
  /**
   * 错误信息
   */
  private String errorMsg;
  
  /**
   * 构造方法 
   */
  public ServiceResult(String desc) {
    this.desc = desc;
  }
  
  /**
   * @return desc
   */
  public String getDesc() {
    return desc;
  }
  
  /**
   * @param desc set desc
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }
  
  /**
   * @return errorMsg
   */
  public String getErrorMsg() {
    return errorMsg;
  }
  
  /**
   * @param errorMsg set errorMsg
   */
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}
