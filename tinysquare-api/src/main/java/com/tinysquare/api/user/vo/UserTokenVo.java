package com.tinysquare.api.user.vo;

import java.io.Serializable;

public class UserTokenVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String account;

	private String token;

	private String tel;

	private String mobile;

	private String email;

	private Byte category;

	public UserTokenVo() {

	}

	public UserTokenVo(String account, String token, String tel, String mobile, String email, Byte category) {
		super();
		this.account = account;
		this.token = token;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.category = category;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getCategory() {
		return category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

}
