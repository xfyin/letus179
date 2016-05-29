/**
 * File：ServiceException.java
 * Package：com.letus179.commons.service
 * Author：xfyin
 * Date：2016-5-24 下午7:24:06
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.dao;

import java.io.Serializable;

/**
 * service层操作结果（异常）
 *
 * @author xfyin
 */
public class ServiceException extends RuntimeException implements Serializable {
  
  /**
   * 序列号
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * 业务逻辑操作信息
   */
  private final ServiceResult serviceResult;
  
  /**
   * 构造器
   */
  public ServiceException(ServiceResult serviceResult) {
    super(serviceResult.getErrorMsg());
    this.serviceResult = serviceResult;
  }
  
  /**
   * 获取操作信息
   * 
   * @return 操作信息
   */
  public String getOptDesc() {
    return serviceResult.getDesc();
  }
  
  /**
   * @return serviceResult
   */
  public ServiceResult getServiceResult() {
    return serviceResult;
  }
}
