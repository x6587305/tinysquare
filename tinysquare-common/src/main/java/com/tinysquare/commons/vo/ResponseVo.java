package com.tinysquare.commons.vo;

import java.io.Serializable;

import com.tinysquare.commons.constants.Constants;

public class ResponseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;

	private String code;

	private String msg;

	private Object result;

	private ResponseVo() {

	}

	private ResponseVo(String code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}

	private ResponseVo(Integer status, String code, String msg, Object result) {
		super();
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.result = result;
	}

	public static ResponseVo success() {
		return new ResponseVo(Constants.Response.SUCCESS, null, null, null);
	}

	public static ResponseVo success(Object object) {
		return new ResponseVo(Constants.Response.SUCCESS, null, null, object);
	}

	public static ResponseVo error(String code) {
		return new ResponseVo(Constants.Response.ERROR, code, null, null);
	}

	public static ResponseVo error(String code, String msg) {
		return new ResponseVo(Constants.Response.ERROR, code, msg, null);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
