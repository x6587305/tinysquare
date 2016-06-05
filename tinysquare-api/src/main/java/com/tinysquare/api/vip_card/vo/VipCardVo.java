package com.tinysquare.api.vip_card.vo;

import java.io.Serializable;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.tools.DataTools;

public class VipCardVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private Long userId;

	private Long shopId;

	private String cardNum;

	private String img;

	private String brief;

	private Long points;

	private Integer userTimes;

	private Byte category;

	private Byte isDefault;

	private Byte status;

	private String entrydate;

	private String shopName;

	public VipCardVo() {
		super();
	}

	public VipCardVo(Long objId, Long userId, Long shopId, String cardNum, String img, String brief, Long points, Integer userTimes, Byte category,
			Byte isDefault, Byte status, String entrydate, String shopName) {
		super();
		this.objId = objId;
		this.userId = userId;
		this.shopId = shopId;
		this.cardNum = cardNum;
		this.img = DataTools.setImg(Constants.App.IMG_URL, img);
		this.brief = brief;
		this.points = points;
		this.userTimes = userTimes;
		this.category = category;
		this.isDefault = isDefault;
		this.status = status;
		this.entrydate = entrydate;
		this.shopName = shopName;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = DataTools.setImg(Constants.App.IMG_URL, img);
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public Integer getUserTimes() {
		return userTimes;
	}

	public void setUserTimes(Integer userTimes) {
		this.userTimes = userTimes;
	}

	public Byte getCategory() {
		return category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

	public Byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Byte isDefault) {
		this.isDefault = isDefault;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
