/**
 * File：CtResult.java
 * Package：com.letus179.commons.bean
 * Author：xfyin
 * Date：2016-5-31 下午12:11:52
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.commons.bean;

/**
 * ontroller层操作结果
 *
 * @author xfyin
 */
public class CtResult {
  
  /**
   * 返回的数据信息
   */
  private Object data;
  
  /**
   * 错误信息
   */
  private String errorMsg;
  
  /**
   * 是否有错误
   */
  private boolean hasErrors;
  
  /**
   * 操作成功，并返回成功结果
   * @param data 成功信息
   * @return CtResult
   */
  public static CtResult success(Object data) {
    CtResult result = new CtResult();
    result.hasErrors = false;
    result.data = data;
    return result;
  }
  
  /**
   * 操作成功，并返回成功结果
   * @return CtResult
   */
  public static CtResult success() {
    CtResult result = new CtResult();
    result.hasErrors = false;
    return result;
  }
  
  /**
   * 操作失败
   * @param message 失败信息
   * @return CtResult
   */
  public static CtResult failure(String message) {
    CtResult result = new CtResult();
    result.hasErrors = true;
    result.errorMsg = message;
    return result;
  }
  
  public boolean isSuccess() {
    return !hasErrors;
  }
  
  public boolean isHasErrors() {
    return hasErrors;
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
  
  /**
   * @return data
   */
  public Object getData() {
    return data;
  }
  
}
