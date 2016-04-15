package com.tinysquare.api.app.vo;

import java.io.Serializable;

public class UpdateVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer appStatus;
	
	private String globalAppPath;
	
	private String updateContent;
	
	private String versions;

	public Integer getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
	}

	public String getGlobalAppPath() {
		return globalAppPath;
	}

	public void setGlobalAppPath(String globalAppPath) {
		this.globalAppPath = globalAppPath;
	}

	public String getUpdateContent() {
		return updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

}
