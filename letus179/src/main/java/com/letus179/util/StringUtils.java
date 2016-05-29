/**
 * File：StringUtils.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-24 下午7:14:51
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作类工具
 * 
 * @author xfyin
 */
public final class StringUtils {
  /**
   * sql非法字符数组 ()[]需要加转义
   * 如有不足 以后再补充
   */
  private static final String[] ILLAGAL_SQL = {" ", "\\(", "\\)", "--", ",", ";", "#"};
  
  /**
   * sql非法字符
   */
  private static String ILLAGAL_SQL_REG = null;
  
  /**
   * 私有化构造器
   */
  private StringUtils() {
  }

  static {
    StringBuilder sb = new StringBuilder("(");
    for (String str : ILLAGAL_SQL) {
      sb.append(str).append("|");
    }
    ILLAGAL_SQL_REG = sb.deleteCharAt(sb.length() - 1).append(")").toString();
  }
  
  /**
   * 验证sql非法字符 包括<code>StringUtils.ILLAGAL_SQL</code>里面的字符则判定非法
   * 
   * @param str
   *        字符串
   * @return 非法返回null 否则返回原字符串
   */
  public static String checkValidSQL(String str) {
    if (str == null) {
      return null;
    }
    
    Pattern p = Pattern.compile(ILLAGAL_SQL_REG);
    Matcher m = p.matcher(str);
    if (m.find()) {
      LS179Logger.error("非法sql注入");
      return null;
    }
    return str;
  }
  
  /**
   * 判断字符串为空串
   * 
   * @param str
   *        要判断的字符串
   * @return 结果
   */
  public static boolean isBlank(String str) {
    return str == null || str.trim().length() == 0;
  }
  
  /**
   * 判断字符串不为空
   * 
   * @param str
   *        需要判断的字符串
   * @return 结果
   */
  public static boolean isNotBlank(String str) {
    return !isBlank(str);
  }
  
  /**
   * 去掉“-”的32位UUID
   * 
   * @return UUID
   */
  public static String get32UUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
