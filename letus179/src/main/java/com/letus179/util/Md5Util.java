/**
 * File：Md5Util.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-28 下午4:17:44
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

/**
 * md5加密
 *
 * @author xfyin
 */
public final class Md5Util {
  
  /**
   * 私有
   */
  private Md5Util() {
  }
  
  /**
   * MD5加密
   * @param source 加密字符串
   * @param salt 盐
   * @return 加密后的字符串
   */
  public static String md5(String source, Integer salt) {
    return new Md5Hash(source, ByteSource.Util.bytes(String.valueOf(salt))).toString();
  }
}
