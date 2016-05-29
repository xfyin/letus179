package com.letus179.commons.entity;

// Generated 2016-5-25 13:42:21 by Hibernate Tools 4.0.0

/**
 * Districts generated by hbm2java
 */
public class Districts implements java.io.Serializable {
  
  private int id;
  
  private Long districtId;
  
  private String district;
  
  private Long cityId;
  
  public Districts() {
  }
  
  public Districts(int id) {
    this.id = id;
  }
  
  public Districts(int id, Long districtId, String district, Long cityId) {
    this.id = id;
    this.districtId = districtId;
    this.district = district;
    this.cityId = cityId;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Long getDistrictId() {
    return this.districtId;
  }
  
  public void setDistrictId(Long districtId) {
    this.districtId = districtId;
  }
  
  public String getDistrict() {
    return this.district;
  }
  
  public void setDistrict(String district) {
    this.district = district;
  }
  
  public Long getCityId() {
    return this.cityId;
  }
  
  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }
  
  public boolean equals(Object other) {
    if ((this == other))
      return true;
    if ((other == null))
      return false;
    if (!(other instanceof Districts))
      return false;
    Districts castOther = (Districts) other;
    
    return (this.getId() == castOther.getId())
        && ((this.getDistrictId() == castOther.getDistrictId()) || (this.getDistrictId() != null
            && castOther.getDistrictId() != null && this.getDistrictId().equals(
            castOther.getDistrictId())))
        && ((this.getDistrict() == castOther.getDistrict()) || (this.getDistrict() != null
            && castOther.getDistrict() != null && this.getDistrict()
            .equals(castOther.getDistrict())))
        && ((this.getCityId() == castOther.getCityId()) || (this.getCityId() != null
            && castOther.getCityId() != null && this.getCityId().equals(castOther.getCityId())));
  }
  
  public int hashCode() {
    int result = 17;
    
    result = 37 * result + this.getId();
    result = 37 * result + (getDistrictId() == null ? 0 : this.getDistrictId().hashCode());
    result = 37 * result + (getDistrict() == null ? 0 : this.getDistrict().hashCode());
    result = 37 * result + (getCityId() == null ? 0 : this.getCityId().hashCode());
    return result;
  }
  
}
