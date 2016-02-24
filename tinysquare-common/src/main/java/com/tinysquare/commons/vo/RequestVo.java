package com.tinysquare.commons.vo;

import java.io.Serializable;

public class RequestVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Byte platform;

	private String token;

	private String version;

	private String sign;

	private Long userId;

	public RequestVo() {

	}

	public RequestVo(Byte platform, String token, String version, String sign) {
		super();
		this.platform = platform;
		this.token = token;
		this.version = version;
		this.sign = sign;
	}

	public Byte getPlatform() {
		return platform;
	}

	public void setPlatform(Byte platform) {
		this.platform = platform;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RequestVo [platform=" + platform + ", token=" + token + ", version=" + version + ", sign=" + sign + ", userId=" + userId + "]";
	}

}
