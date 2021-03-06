package com.letus179.commons.entity;

// Generated 2016-5-30 17:52:43 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String id;
  
  private String realName;
  
  private String username;
  
  private String password;
  
  private String salt;
  
  private int locked;
  
  private Integer age;
  
  private Integer loveStatus;
  
  private Integer gender;
  
  private String signature;
  
  private String idCard;
  
  private String phone;
  
  private String email;
  
  private String headUrl;
  
  private Date birthday;
  
  private Integer isPhoneVerify;
  
  private Integer degreeType;
  
  private Date createTime;
  
  private Date updateTime;
  
  private String province;
  
  private String city;
  
  private String district;
  
  private Statisticalaccess statisticalaccess;
  
  public User() {
  }
  
  public User(String id, String realName, String password, String salt, int locked) {
    this.id = id;
    this.realName = realName;
    this.password = password;
    this.salt = salt;
    this.locked = locked;
  }
  
  /**
   * @param id
   * @param statisticalaccess
   * @param realName
   * @param username
   * @param password
   * @param salt
   * @param locked
   * @param age
   * @param loveStatus
   * @param gender
   * @param signature
   * @param idCard
   * @param phone
   * @param email
   * @param headUrl
   * @param birthday
   * @param isPhoneVerify
   * @param degreeType
   * @param createTime
   * @param updateTime
   * @param province
   * @param city
   * @param district
   */
  public User(String id, String realName, String username, String password, String salt, int locked,
      Integer age, Integer loveStatus, Integer gender, String signature, String idCard,
      String phone, String email, String headUrl, Date birthday, Integer isPhoneVerify,
      Integer degreeType, Date createTime, Date updateTime, String province, String city,
      String district) {
    super();
    this.id = id;
    this.realName = realName;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.locked = locked;
    this.age = age;
    this.loveStatus = loveStatus;
    this.gender = gender;
    this.signature = signature;
    this.idCard = idCard;
    this.phone = phone;
    this.email = email;
    this.headUrl = headUrl;
    this.birthday = birthday;
    this.isPhoneVerify = isPhoneVerify;
    this.degreeType = degreeType;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.province = province;
    this.city = city;
    this.district = district;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getRealName() {
    return this.realName;
  }
  
  public void setRealName(String realName) {
    this.realName = realName;
  }
  
  /**
   * @return username
   */
  public String getUsername() {
    return username;
  }
  
  /**
   * @param username set username
   */
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getSalt() {
    return this.salt;
  }
  
  public void setSalt(String salt) {
    this.salt = salt;
  }
  
  public int getLocked() {
    return this.locked;
  }
  
  public void setLocked(int locked) {
    this.locked = locked;
  }
  
  public Integer getAge() {
    return this.age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Integer getLoveStatus() {
    return this.loveStatus;
  }
  
  public void setLoveStatus(Integer loveStatus) {
    this.loveStatus = loveStatus;
  }
  
  public Integer getGender() {
    return this.gender;
  }
  
  public void setGender(Integer gender) {
    this.gender = gender;
  }
  
  public String getSignature() {
    return this.signature;
  }
  
  public void setSignature(String signature) {
    this.signature = signature;
  }
  
  public String getIdCard() {
    return this.idCard;
  }
  
  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getHeadUrl() {
    return this.headUrl;
  }
  
  public void setHeadUrl(String headUrl) {
    this.headUrl = headUrl;
  }
  
  public Date getBirthday() {
    return this.birthday;
  }
  
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  
  public Integer getIsPhoneVerify() {
    return this.isPhoneVerify;
  }
  
  public void setIsPhoneVerify(Integer isPhoneVerify) {
    this.isPhoneVerify = isPhoneVerify;
  }
  
  public Integer getDegreeType() {
    return this.degreeType;
  }
  
  public void setDegreeType(Integer degreeType) {
    this.degreeType = degreeType;
  }
  
  public Date getCreateTime() {
    return this.createTime;
  }
  
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  
  public Date getUpdateTime() {
    return this.updateTime;
  }
  
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
  
  public String getProvince() {
    return this.province;
  }
  
  public void setProvince(String province) {
    this.province = province;
  }
  
  public String getCity() {
    return this.city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getDistrict() {
    return this.district;
  }
  
  public void setDistrict(String district) {
    this.district = district;
  }
  
  /**
   * @return statisticalaccess
   */
  public Statisticalaccess getStatisticalaccess() {
    return statisticalaccess;
  }
  
  /**
   * @param statisticalaccess set statisticalaccess
   */
  public void setStatisticalaccess(Statisticalaccess statisticalaccess) {
    this.statisticalaccess = statisticalaccess;
  }
  
}
