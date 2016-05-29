/**
 * File：HttpUtils.java
 * Package：com.letus179.util
 * Author：xfyin
 * Date：2016-5-24 下午7:26:58
 * Copyright (C) 2016-2016 letus179-Copyright
 */
package com.letus179.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.letus179.commons.dao.ServiceException;
import com.letus179.commons.dao.ServiceResult;


/**
 * Http 请求帮助类
 * 通过该类发送GET,POST请求，获取网络接口返回的字符串
 *
 * @author xfyin
 */
public final class HttpUtils {
  /**
   * 验证http请求参数成功
   */
  private static final String VERIFY_SUCCESS = "verify_http_param_success";
  
  /**
   * 私有化构造器
   */
  private HttpUtils() {
  }
  
  /**
   * 发送Post请求返回字符串
   * 
   * @param url
   *        目的地址
   * @param params
   *        参数
   * @param httpHeads
   *        http请求头
   * @param conTimeout
   *        连接超时时长（毫秒）
   * @param readTimeout
   *        读取接口数据超时时长（毫秒）
   * @param inCharset
   *        输入编码
   * @param outCharset
   *        输出编码
   * @return 返回字符串
   */
  public static String post(String url, Map<String, String> params, Map<String, String> httpHeads,
                            int conTimeout, int readTimeout, String inCharset, String outCharset) {
    String result = "";
    String paramsVerifyResult = httpParamVerify(url, conTimeout, readTimeout, inCharset, outCharset);
    if (!VERIFY_SUCCESS.equals(paramsVerifyResult)) {
      return paramsVerifyResult;
    }
    InputStream in = getInputStreamByPostMethod(url, params, httpHeads, conTimeout, readTimeout,
        outCharset);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(in, inCharset));
      String line = "";
      while ((line = reader.readLine()) != null) {
        result += line;
      }
    }
    catch (Exception e) {
      LS179Logger.error(e);
    }
    finally {
      IOUtils.closeQuietly(reader);
      IOUtils.closeQuietly(in);
    }
    return result;
  }
  
  /**
   * 发送post请求获取输入流
   * 
   * @param url
   *        目的地址
   * @param params
   *        发送参数
   * @param httpHeaders
   *        http请求头信息
   * @param conTimeout
   *        连接超时时长
   * @param readTimeout
   *        读取超时时长
   * @param outCharset
   *        输出流编码
   * @return 输入流
   */
  public static InputStream getInputStreamByPostMethod(String url, Map<String, String> params,
                                                       Map<String, String> httpHeaders,
                                                       int conTimeout, int readTimeout,
                                                       String outCharset) {
    String paramsVerifyResult = httpParamVerify(url, conTimeout, readTimeout, "ignore", outCharset);
    if (!VERIFY_SUCCESS.equals(paramsVerifyResult)) {
      return null;
    }
    StringBuilder msg = new StringBuilder(512);
    msg.append("HttpPost - URL=[").append(url);
    InputStream in = null;
    OutputStreamWriter out = null;
    long timeStart = System.currentTimeMillis();
    String paramsStirng = "";
    if (params != null) {
      paramsStirng = mapToString(params, outCharset);
    }
    msg.append("], Paramter=[").append(paramsStirng);
    try {
      URL realURL = new URL(url);
      URLConnection conn = realURL.openConnection();
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent",
          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
      if (httpHeaders != null) {
        for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
          conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
      }
      conn.setConnectTimeout(conTimeout);
      conn.setReadTimeout(readTimeout);
      // 设置post请求必须设置下列两行
      conn.setDoOutput(true);
      conn.setDoInput(true);
      out = new OutputStreamWriter(conn.getOutputStream(), outCharset);
      // 发送请求参数
      out.write(paramsStirng);
      out.flush();
      in = conn.getInputStream();
      long timeEnd = System.currentTimeMillis();
      msg.append("], TimeUsed=[").append(timeEnd - timeStart).append("]");
      LS179Logger.info(msg.toString());
    }
    catch (Exception e) {
      long timeEnd = System.currentTimeMillis();
      msg.append("], Error");
      msg.append("], TimeUsed=[").append(timeEnd - timeStart).append("]");
      LS179Logger.error(msg.toString());
    }
    finally {
      IOUtils.closeQuietly(out);
    }
    return in;
  }
  
  /**
   * 发送GET请求返回字符串
   * 
   * @param url
   *        目的地址
   * @param params
   *        参数
   * @param httpHeaders
   *        http请求头
   * @param connTimeout
   *        连接超时时长（毫秒）
   * @param readTimeout
   *        读取接口数据超时时长（毫秒）
   * @param inCharset
   *        输入编码
   * @param outCharset
   *        输出编码
   * @return 返回字符串
   */
  public static String get(String url, Map<String, String> params, Map<String, String> httpHeaders,
                           int connTimeout, int readTimeout, String inCharset, String outCharset) {
    String result = "";
    String paramsVerifyResult = httpParamVerify(url, connTimeout, readTimeout, inCharset,
        outCharset);
    if (!VERIFY_SUCCESS.equals(paramsVerifyResult)) {
      return paramsVerifyResult;
    }
    InputStream in = getInputStreamByGetMethod(url, params, httpHeaders, connTimeout, readTimeout,
        outCharset);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(in, inCharset));
      String line = "";
      while ((line = reader.readLine()) != null) {
        result += line;
      }
    }
    catch (Exception e) {
      LS179Logger.error(e);
    }
    finally {
      IOUtils.closeQuietly(reader);
      IOUtils.closeQuietly(in);
    }
    return result;
    
  }
  
  /**
   * 发送get请求获取输入流
   * 
   * @param url
   *        目的地址
   * @param params
   *        发送参数
   * @param httpHeaders
   *        http请求头信息
   * @param connTimeout
   *        连接超时时长
   * @param readTimeout
   *        读取超时时长
   * @param outCharset
   *        输出流编码
   * @return 输入流
   */
  public static InputStream getInputStreamByGetMethod(String url, Map<String, String> params,
                                                      Map<String, String> httpHeaders,
                                                      int connTimeout, int readTimeout,
                                                      String outCharset) {
    String paramsVerifyResult = httpParamVerify(url, connTimeout, readTimeout, "ignore", outCharset);
    if (!VERIFY_SUCCESS.equals(paramsVerifyResult)) {
      return null;
    }
    String urlParams = null;
    if (params != null) {
      urlParams = joinUrlAndParams(url, params, outCharset);
    }
    StringBuilder msg = new StringBuilder(512);
    msg.append("HttpGet - URL=[").append(urlParams);
    long timeStart = System.currentTimeMillis();
    InputStream in = null;
    try {
      URL realUrl = new URL(urlParams);
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent",
          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
      conn.setConnectTimeout(connTimeout);
      conn.setReadTimeout(readTimeout);
      if (httpHeaders != null) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
          conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
      }
      // 建立实际的连接
      conn.getContent();
      in = conn.getInputStream();
      long timeEnd = System.currentTimeMillis();
      msg.append("], TimeUsed=[").append(timeEnd - timeStart).append("]");
      LS179Logger.info(msg.toString());
    }
    catch (Exception e) {
      long timeEnd = System.currentTimeMillis();
      msg.append("], ERROR=[").append(e);
      msg.append("], TimeUsed=[").append(timeEnd - timeStart).append("]");
      LS179Logger.error(msg.toString());
    }
    return in;
  }
  
  /**
   * 对各参数进行校验判断
   * 
   * @param url
   *        地址
   * @param conTimeout
   *        连接超时时长
   * @param readTimeout
   *        读取超时时长
   * @param inCharset
   *        输入流编码
   * @param outCharset
   *        输出流编码
   * @return 结果
   */
  private static String httpParamVerify(String url, int conTimeout, int readTimeout,
                                        String inCharset, String outCharset) {
    
    if (StringUtils.isBlank(url)) {
      LS179Logger.error("请求字符串不能为空");
      return "请求字符串不能为空";
    }
    if (conTimeout <= 0) {
      LS179Logger.error(url + "请求时，必须设置连接时间");
      return "请求时，必须设置连接时间";
    }
    if (readTimeout <= 0) {
      LS179Logger.error(url + "请求时，必须设置读取时间");
      return "请求时，必须设置读取时间";
    }
    
    if (StringUtils.isBlank(inCharset)) {
      LS179Logger.error(url + "请求时，获取输入流编码不能为空");
      return "请求时，获取输入流编码不能为空";
    }
    if (StringUtils.isBlank(outCharset)) {
      LS179Logger.error(url + "请求时，获取输入出流编码不能为空");
      return "请求时，获取输出流编码不能为空";
    }
    return VERIFY_SUCCESS;
  }
  
  /**
   * 将map中的参数转换成key=value&key=value&...的形式返回字符串
   * 
   * @param params
   *        参数
   * @param charset
   *        参数编码
   * @return 字符串
   */
  public static String mapToString(Map<String, String> params, String charset) {
    StringBuilder builder = new StringBuilder(128);
    for (Map.Entry<String, String> entry : params.entrySet()) {
      String param = entry.getValue();
      try {
        param = URLEncoder.encode(param, charset);
      }
      catch (UnsupportedEncodingException e) {
        LS179Logger.error(e);
      }
      if (builder.length() > 0) {
        builder.append("&");
      }
      builder.append(entry.getKey()).append("=").append(param);
    }
    return builder.toString();
  }
  
  /**
   * 根据地址和参数拼接URL
   * 
   * @param url
   *        目的地址
   * @param params
   *        参数
   * @param charset
   *        参数编码方式
   * @return 拼接的URL
   */
  public static String joinUrlAndParams(String url, Map<String, String> params, String charset) {
    StringBuilder builder = new StringBuilder(url.length() + 128);
    builder.append(url);
    int len = url.length();
    if (url.indexOf("?") > 0) {
      if (!url.endsWith("?")) {
        len--;
      }
    }
    else {
      builder.append("?");
      len++;
    }
    for (Map.Entry<String, String> entry : params.entrySet()) {
      String value = entry.getValue();
      try {
        value = URLEncoder.encode(value, charset);
      }
      catch (UnsupportedEncodingException e) {
        LS179Logger.error(e);
      }
      if (builder.length() > len) {
        builder.append("&");
      }
      builder.append(entry.getKey()).append("=").append(value);
    }
    return charset;
  }
  
  /**
   * 将获取的输入流写入指定路径的文件中
   * 
   * @param in
   *        输入流
   * @param fileNamePath
   *        文件路径+文件名
   * @param charset
   *        输入流的编码方式
   */
  public static void writeInToFile(InputStream in, String fileNamePath, String charset) {
    ServiceResult result = new ServiceResult("将输入流写入文件中");
    if (in == null) {
      LS179Logger.error("输入流不存在");
      result.setErrorMsg("输入流不存在");
      throw new ServiceException(result);
    }
    FileOutputStream os = null;
    try {
      os = new FileOutputStream(fileNamePath);
      byte[] b = new byte[1024];
      while (in.read(b) != -1) {
        // os.write(b);这种方式可能会导致写入文件中，出现异常
        String str = new String(b, charset).trim();
        os.write(str.getBytes());
      }
    }
    catch (Exception e) {
      LS179Logger.error(e + "输入流写入文件失败");
      result.setErrorMsg("输入流写入文件失败");
      throw new ServiceException(result);
    }
    finally {
      IOUtils.closeQuietly(os);
      IOUtils.closeQuietly(in);
    }
  }
  
  /**
   * 读取指定路径下的文件到list中（后续遍历该list，根据下标插入数据库保存记录）
   * 
   * @param fileNamePath
   *        文件路径及文件名
   * @return list记录
   */
  public static List<String> readFileToList(String fileNamePath) {
    ServiceResult result = new ServiceResult("将指定路径下的文件读取存入list集合中");
    List<String> list = new ArrayList<>();
    File file = new File(fileNamePath);
    if (!file.exists()) {
      LS179Logger.error(fileNamePath + ":文件不存在");
      result.setErrorMsg("文件不存在");
      throw new ServiceException(result);
    }
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      while (line != null) {
        // TODO 首先应该校验该文件是否是合法文件，并选择从哪一行数据开始读并存入list中
        list.add(line);
      }
    }
    catch (Exception e) {
      LS179Logger.error(fileNamePath + "获取文件内容失败");
      result.setErrorMsg("获取文件内容失败");
      throw new ServiceException(result);
    }
    return list;
  }
}
