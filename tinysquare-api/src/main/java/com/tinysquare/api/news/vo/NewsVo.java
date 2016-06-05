package com.tinysquare.api.news.vo;

import java.io.Serializable;
import java.util.List;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.vo.ShareVo;

import com.tinysquare.tools.DataTools;

public class NewsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private String shopName;

	private String content;

	private Long shopId;

	private String entrydate;

	private String avator;

	private Long favoriteCount;

	private String distance;

	public Byte status;

	private Byte canFavorite = Constants.Boolean.FALSE;

	private ShareVo share;

	private List<NewsImgVo> imgs;

	public NewsVo() {

	}

	public NewsVo(Long objId, String shopName, String content, Long shopId, String entrydate, String avator, Long favoriteCount, String distance) {
		super();
		this.objId = objId;
		this.shopName = shopName;
		this.content = content;
		this.shopId = shopId;
		this.entrydate = entrydate;
		this.avator = DataTools.setImg(Constants.App.IMG_URL, avator);
		this.favoriteCount = favoriteCount;
		this.distance = distance;
	}

	public NewsVo(Long objId, String shopName, String content, Long shopId, String entrydate, String avator, Long favoriteCount, String distance, Byte status) {
		super();
		this.objId = objId;
		this.shopName = shopName;
		this.content = content;
		this.shopId = shopId;
		this.entrydate = entrydate;
		this.avator = DataTools.setImg(Constants.App.IMG_URL, avator);
		this.favoriteCount = favoriteCount;
		this.distance = distance;
		this.status = status;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getCanFavorite() {
		return canFavorite;
	}

	public void setCanFavorite(Byte canFavorite) {
		this.canFavorite = canFavorite;
	}

	public ShareVo getShare() {
		return share;
	}

	public void setShare(ShareVo share) {
		this.share = share;
	}

	public List<NewsImgVo> getImgs() {
		return imgs;
	}

	public void setImgs(List<NewsImgVo> imgs) {
		this.imgs = imgs;
	}

	public void setNewShare() {
		String brief = this.content;
		if (brief != null && brief.length() > 30) {
			brief = brief.substring(0, 30) + "...";
		}

		this.setShare(new ShareVo(this.avator, this.shopName, brief, Constants.News.SHARE_URL + this.objId));
	}

}
