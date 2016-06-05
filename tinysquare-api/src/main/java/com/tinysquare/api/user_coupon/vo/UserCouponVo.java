package com.tinysquare.api.user_coupon.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.tools.DataTools;

public class UserCouponVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private Long userId;

	private Long couponId;

	private Byte status;

	private String entrydate;

	private Long shopId;

	private String shopName;

	private String couponName;

	private String couponImg;

	private Byte category;

	private BigDecimal amount;

	private String startTime;

	private String endTime;

	public UserCouponVo(Long objId, Long userId, Long couponId, Byte status, String entrydate, Long shopId, String shopName, String couponName,
			String couponImg, Byte category, BigDecimal amount, String startTime, String endTime) {
		super();
		this.objId = objId;
		this.userId = userId;
		this.couponId = couponId;
		this.status = status;
		this.entrydate = entrydate;
		this.shopId = shopId;
		this.shopName = shopName;
		this.couponName = couponName;
		this.couponImg = DataTools.setImg(Constants.App.IMG_URL, couponImg);
		this.category = category;
		this.amount = amount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponImg() {
		return couponImg;
	}

	public void setCouponImg(String couponImg) {
		this.couponImg = DataTools.setImg(Constants.App.IMG_URL, couponImg);
	}

	public Byte getCategory() {
		return category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
