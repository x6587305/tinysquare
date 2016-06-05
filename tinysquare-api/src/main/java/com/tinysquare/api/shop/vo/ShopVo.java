package com.tinysquare.api.shop.vo;

import java.io.Serializable;
import java.util.List;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.tools.DataTools;

public class ShopVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private Long userId;

	private String name;

	private String avator;

	private String mobile;

	private String tel;

	private String address;

	private String brief;

	private String description;

	private Long favoriteCount;

	private Double lng;

	private Double lat;

	private Double distance;

	private List<ShopImgVo> imgs;

	public ShopVo() {

	}

	public ShopVo(Long objId, Long userId, String name, String avator, String mobile, String tel, String address, String brief, String description,
			Long favoriteCount, Double lng, Double lat) {
		super();
		this.objId = objId;
		this.userId = userId;
		this.name = name;
		this.avator = DataTools.setImg(Constants.App.IMG_URL, avator);
		this.mobile = mobile;
		this.tel = tel;
		this.address = address;
		this.brief = brief;
		this.description = description;
		this.favoriteCount = favoriteCount;
		this.lng = lng;
		this.lat = lat;
	}

	public ShopVo(Long objId, Long userId, String name, String avator, String mobile, String tel, String address, String brief, String description,
			Long favoriteCount, Double distance) {
		super();
		this.objId = objId;
		this.userId = userId;
		this.name = name;
		this.avator = DataTools.setImg(Constants.App.IMG_URL, avator);
		this.mobile = mobile;
		this.tel = tel;
		this.address = address;
		this.brief = brief;
		this.description = description;
		this.favoriteCount = favoriteCount;
		this.distance = distance;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<ShopImgVo> getImgs() {
		return imgs;
	}

	public void setImgs(List<ShopImgVo> imgs) {
		this.imgs = imgs;
	}

}
