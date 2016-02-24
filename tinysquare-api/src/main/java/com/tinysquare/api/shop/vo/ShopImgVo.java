package com.tinysquare.api.shop.vo;

import java.io.Serializable;

public class ShopImgVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private String url;

	public ShopImgVo() {

	}

	public ShopImgVo(Long objId, String url) {
		super();
		this.objId = objId;
		this.url = url;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
