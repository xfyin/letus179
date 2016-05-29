/**
 * File：Letus179Logger.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-24 下午7:16:56
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;


import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

import ch.qos.logback.classic.Logger;
/**
 * logback封装类
 *
 * @author xfyin
 */
public final class LS179Logger {
  /**
   * 类名
   */
  private static final String LS = LS179Logger.class.getName();
  
  /**
   * logback的logger
   */
  private static final Logger logger = (Logger) LoggerFactory.getLogger(LS179Logger.class);
  
  /**
   * 私有化构造器
   */
  private LS179Logger() {
  }
  
  public static void debug(String msg) {
    logger.log(null, LS, LocationAwareLogger.DEBUG_INT, msg, null, null);
  }

  public static void debug(String format, Object arg) {
    logger.log(null, LS, LocationAwareLogger.DEBUG_INT, format, new Object[]{arg}, null);
  }

  public static void debug(String format, Object arg1, Object arg2) {
    logger.log(null, LS, LocationAwareLogger.DEBUG_INT, format, new Object[]{arg1,arg2}, null);
  }

  public static void debug(String format, Object... arguments) {
    logger.log(null, LS, LocationAwareLogger.DEBUG_INT, format, arguments, null);
  }

  public static void debug(String msg, Throwable t) {
    logger.log(null, LS, LocationAwareLogger.DEBUG_INT, msg, null, t);
  }

  public static boolean isDebugEnabled(Marker marker) {
    return logger.isDebugEnabled(marker);
  }

  public static void debug(Marker marker, String msg) {
    logger.log(marker, LS, LocationAwareLogger.DEBUG_INT, msg, null, null);
  }

  public static void debug(Marker marker, String format, Object arg) {
    logger.log(marker, LS, LocationAwareLogger.DEBUG_INT, format, new Object[]{arg}, null);
  }

  public static void debug(Marker marker, String format, Object arg1, Object arg2) {
    logger.log(marker, LS, LocationAwareLogger.DEBUG_INT, format, new Object[]{arg1,arg2}, null);
  }

  public static void debug(Marker marker, String format, Object... arguments) {
    logger.log(marker, LS, LocationAwareLogger.DEBUG_INT, format, arguments, null);
  }

  public static void debug(Marker marker, String msg, Throwable t) {
    logger.log(marker, LS, LocationAwareLogger.DEBUG_INT, msg, null, t);
  }

  public static boolean isInfoEnabled() {
    return logger.isInfoEnabled();
  }

  public static void info(String msg) {
    logger.log(null, LS, LocationAwareLogger.INFO_INT, msg, null, null);
  }

  public static void info(String format, Object arg) {
    logger.log(null, LS, LocationAwareLogger.INFO_INT, format, new Object[]{arg}, null);
  }


  public static void info(String format, Object arg1, Object arg2) {
    logger.log(null, LS, LocationAwareLogger.INFO_INT, format,new Object[]{arg1,arg2}, null);
  }


  public static void info(String format, Object... arguments) {
    logger.log(null, LS, LocationAwareLogger.INFO_INT, format,arguments, null);
  }


  public void info(String msg, Throwable t) {
    logger.log(null, LS, LocationAwareLogger.INFO_INT, msg,null, t);
  }


  public static boolean isInfoEnabled(Marker marker) {
    return logger.isInfoEnabled(marker);
  }


  public static void info(Marker marker, String msg) {
    logger.log(marker, LS, LocationAwareLogger.INFO_INT, msg, null, null);
  }


  public static void info(Marker marker, String format, Object arg) {
    logger.log(marker, LS, LocationAwareLogger.INFO_INT, format, new Object[]{arg}, null);
  }


  public static void info(Marker marker, String format, Object arg1, Object arg2) {
    logger.log(marker, LS, LocationAwareLogger.INFO_INT, format,new Object[]{arg1,arg2}, null);
  }


  public static void info(Marker marker, String format, Object... arguments) {
    logger.log(marker, LS, LocationAwareLogger.INFO_INT, format,arguments, null);
  }


  public static void info(Marker marker, String msg, Throwable t) {
    logger.log(marker, LS, LocationAwareLogger.INFO_INT, msg,null, t);
  }


  public static boolean isWarnEnabled() {
    return logger.isWarnEnabled();
  }


  public static void warn(String msg) {
    logger.log(null, LS, LocationAwareLogger.WARN_INT, msg, null, null);
  }


  public static void warn(String format, Object arg) {
    logger.log(null, LS, LocationAwareLogger.WARN_INT, format, new Object[]{arg}, null);
  }


  public static void warn(String format, Object... arguments) {
    logger.log(null, LS, LocationAwareLogger.WARN_INT, format,arguments, null);
  }


  public static void warn(String format, Object arg1, Object arg2) {
    logger.log(null, LS, LocationAwareLogger.WARN_INT, format,new Object[]{arg1,arg2}, null);
  }


  public static void warn(String msg, Throwable t) {
    logger.log(null, LS, LocationAwareLogger.WARN_INT, msg,null, t);
  }


  public boolean isWarnEnabled(Marker marker) {
    return logger.isWarnEnabled(marker);
  }


  public static void warn(Marker marker, String msg) {
    logger.log(marker, LS, LocationAwareLogger.WARN_INT, msg, null, null);
  }


  public static void warn(Marker marker, String format, Object arg) {
    logger.log(marker, LS, LocationAwareLogger.WARN_INT, format, new Object[]{arg}, null);
  }


  public static void warn(Marker marker, String format, Object arg1, Object arg2) {
    logger.log(marker, LS, LocationAwareLogger.WARN_INT, format,new Object[]{arg1,arg2}, null);
  }


  public static void warn(Marker marker, String format, Object... arguments) {
    logger.log(marker, LS, LocationAwareLogger.WARN_INT, format,arguments, null);
  }


  public static void warn(Marker marker, String msg, Throwable t) {
    logger.log(marker, LS, LocationAwareLogger.WARN_INT, msg,null, t);
  }


  public boolean isErrorEnabled() {
    return logger.isErrorEnabled();
  }

  
  /**
   * 输出error级别信息
   * @see BdpLogger.error(String msg, Throwable t) {
   * 
   * @param e
   *        异常
   */
  @Deprecated
  public static void error(Exception e) {
     logger.log(null, LS, LocationAwareLogger.ERROR_INT, e.toString(), null, e);
  }

  public static void error(String msg) {
    logger.log(null, LS, LocationAwareLogger.ERROR_INT, msg, null, null);
  }


  public static void error(String format, Object arg) {
    logger.log(null, LS, LocationAwareLogger.ERROR_INT, format, new Object[]{arg}, null);
  }


  public static void error(String format, Object arg1, Object arg2) {
    logger.log(null, LS, LocationAwareLogger.ERROR_INT, format, new Object[]{arg1,arg2}, null);
  }


  public static void error(String format, Object... arguments) {
    logger.log(null, LS, LocationAwareLogger.ERROR_INT, format,arguments, null);
  }


  public static void error(String msg, Throwable t) {
    logger.log(null, LS, LocationAwareLogger.ERROR_INT, msg,null, t);
  }


  public boolean isErrorEnabled(Marker marker) {
    return logger.isErrorEnabled(marker);
  }


  public static void error(Marker marker, String msg) {
    logger.log(marker, LS, LocationAwareLogger.ERROR_INT, msg, null, null);
  }


  public static void error(Marker marker, String format, Object arg) {
    logger.log(marker, LS, LocationAwareLogger.ERROR_INT, format, new Object[]{arg}, null);
  }


  public static void error(Marker marker, String format, Object arg1, Object arg2) {
    logger.log(marker, LS, LocationAwareLogger.ERROR_INT, format, new Object[]{arg1,arg2}, null);
  }


  public static void error(Marker marker, String format, Object... arguments) {
    logger.log(marker, LS, LocationAwareLogger.ERROR_INT, format,arguments, null);
  }


  public static void error(Marker marker, String msg, Throwable t) {
    logger.log(marker, LS, LocationAwareLogger.ERROR_INT, msg,null, t);
  }
  
}
