/**
 * File：PropsUtils.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-24 下午7:20:53
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;


/**
 * properties文件读取工具类
 *
 * @author xfyin
 */
public final class PropsUtils {
  /**
   * 私有构造器
   */
  private PropsUtils() {
  }
  
  /**
   * 根据配置文件和key值获取value值
   * 
   * @param address
   *        配置文件
   * @param key
   *        key值
   * @return value
   */
  public static String getProperties(String address, String key) {
    InputStream in = PropsUtils.class.getClassLoader().getResourceAsStream(address);
    if (in == null) {
      LS179Logger.error("can not find address: " + address);
      throw new RuntimeException("can not find address: " + address);
    }
    Properties prop = new Properties();
    try {
      prop.load(in);
    }
    catch (IOException e) {
      LS179Logger.error(e + "read file failure...");
    }
    finally {
      IOUtils.closeQuietly(in);
    }
    return prop.getProperty(key);
  }
  
  /**
   * 根据配置文件、编码方式和key值获取value值
   * 
   * @param address
   *        配置文件
   * @param key
   *        key值
   * @param encoding
   *        编码方式
   * @return value 值
   */
  public static String getProperties(String address, String key, String encoding) {
    
    InputStreamReader in = null;
    Properties prop = null;
    try {
      in = new InputStreamReader(Properties.class.getClassLoader().getResourceAsStream(address),
          encoding);
      prop = new Properties();
      prop.load(in);
    }
    catch (Exception e) {
      LS179Logger.error(e + "read file failure...");
    }
    finally {
      try {
        in.close();
      }
      catch (IOException e) {
        LS179Logger.error(e + "after read file, closing stream failure ");
      }
    }
    
    return prop.getProperty(key);
    
  }
  
  /**
   * 获取配置文件中的key-value存入list中（key-value左右两边去空格）
   * 
   * @param address
   *        配置文件
   * @return list keyvalue
   */
  public static List<String[]> getPropertiesList(String address) {
    List<String[]> list = new ArrayList<>();
    // 获取输入流
    InputStream in = PropsUtils.class.getClassLoader().getResourceAsStream(address);
    if (in == null) {
      LS179Logger.error("can not find address: " + address);
      throw new RuntimeException("can not find address: " + address);
    }
    // 读取字符串
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    try {
      String line = "";
      // 跳过注释行
      while (!(line = reader.readLine()).startsWith("#")) {
        if (StringUtils.isNotBlank(line)) {
          String[] keyvalue = line.split("=");
          // 获取key值，并去掉两边空格
          keyvalue[0] = keyvalue[0].trim();
          // 获取value值，并去掉两边空格
          keyvalue[1] = keyvalue[1].trim();
          list.add(keyvalue);
        }
      }
    }
    catch (IOException e) {
      LS179Logger.error(e + "read file failure...");
    }
    finally {
      IOUtils.closeQuietly(reader);
      IOUtils.closeQuietly(in);
    }
    return list;
  }
  
  /**
   * 获取配置文件中的keyvalue值并存入map中
   * 
   * @param address
   *        配置文件
   * @return map
   */
  public static Map<String, String> getPropertiesMap(String address) {
    Map<String, String> map = new HashMap<>();
    // 获取输入流
    InputStream in = PropsUtils.class.getClassLoader().getResourceAsStream(address);
    if (in == null) {
      LS179Logger.error("can not find address: " + address);
      throw new RuntimeException("can not find address: " + address);
    }
    // 读取字符串
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line = "";
    try {
      while ((line = reader.readLine()) != null) {
        if (!line.startsWith("#")) {
          String[] keyvalue = line.split("=");
          if (keyvalue.length == 2) {
            map.put(keyvalue[0].trim(), keyvalue[1].trim());
          }
        }
      }
    }
    catch (IOException e) {
      LS179Logger.error(e + "get stream failure...");
    }
    finally {
      IOUtils.closeQuietly(reader);
      IOUtils.closeQuietly(in);
    }
    return map;
  }
}
