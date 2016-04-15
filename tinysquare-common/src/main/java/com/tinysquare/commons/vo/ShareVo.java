package com.tinysquare.commons.vo;

import java.io.Serializable;

public class ShareVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String icon;

	private String title;
	
	private String brief;
	
	private String url;

	public ShareVo(String icon, String title, String brief, String url) {
		super();
		this.icon = icon;
		this.title = title;
		this.brief = brief;
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
