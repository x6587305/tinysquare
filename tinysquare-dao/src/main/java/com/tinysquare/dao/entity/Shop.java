package com.tinysquare.dao.entity;

import java.util.Date;

public class Shop {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.user_id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.avator
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String avator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.name
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.mobile
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.tel
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.address
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.brief
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String brief;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.description
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.favorite_count
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Long favoriteCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.longitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Double longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.latitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Double latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.status
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tiny_shop.entrydate
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    private Date entrydate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.id
     *
     * @return the value of tiny_shop.id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.id
     *
     * @param id the value for tiny_shop.id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.user_id
     *
     * @return the value of tiny_shop.user_id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.user_id
     *
     * @param userId the value for tiny_shop.user_id
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.avator
     *
     * @return the value of tiny_shop.avator
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getAvator() {
        return avator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.avator
     *
     * @param avator the value for tiny_shop.avator
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setAvator(String avator) {
        this.avator = avator == null ? null : avator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.name
     *
     * @return the value of tiny_shop.name
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.name
     *
     * @param name the value for tiny_shop.name
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.mobile
     *
     * @return the value of tiny_shop.mobile
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.mobile
     *
     * @param mobile the value for tiny_shop.mobile
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.tel
     *
     * @return the value of tiny_shop.tel
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.tel
     *
     * @param tel the value for tiny_shop.tel
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.address
     *
     * @return the value of tiny_shop.address
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.address
     *
     * @param address the value for tiny_shop.address
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.brief
     *
     * @return the value of tiny_shop.brief
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getBrief() {
        return brief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.brief
     *
     * @param brief the value for tiny_shop.brief
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.description
     *
     * @return the value of tiny_shop.description
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.description
     *
     * @param description the value for tiny_shop.description
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.favorite_count
     *
     * @return the value of tiny_shop.favorite_count
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Long getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.favorite_count
     *
     * @param favoriteCount the value for tiny_shop.favorite_count
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.longitude
     *
     * @return the value of tiny_shop.longitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.longitude
     *
     * @param longitude the value for tiny_shop.longitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.latitude
     *
     * @return the value of tiny_shop.latitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.latitude
     *
     * @param latitude the value for tiny_shop.latitude
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.status
     *
     * @return the value of tiny_shop.status
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.status
     *
     * @param status the value for tiny_shop.status
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tiny_shop.entrydate
     *
     * @return the value of tiny_shop.entrydate
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public Date getEntrydate() {
        return entrydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tiny_shop.entrydate
     *
     * @param entrydate the value for tiny_shop.entrydate
     *
     * @mbggenerated Tue Apr 12 22:52:32 CST 2016
     */
    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }
}