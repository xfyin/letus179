/**
 * File：RandonUtil.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-28 下午3:53:15
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

/**
 * 生成随机数
 *
 * @author xfyin
 */
public final class RandomUtil {
  
  /**
   * 私有
   */
  private RandomUtil() {
  }
  
  /**
   * 生成指定范围内的随机数（并非伪随机数）
   * new Random().nextInt(end)%(end - from +1)+ from 属于伪随机数
   * @param from 下限
   * @param end 上限
   * @return 随机数
   */
  public static int getSalt(int from, int end) {
    int number = 0;
    for (int i = from; i <= end; i++) {
      number = (int) (Math.random() * i + 1);
    }
    return number;
  }
}
