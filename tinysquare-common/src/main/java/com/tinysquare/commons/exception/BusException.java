package com.tinysquare.commons.exception;

import com.tinysquare.commons.constants.Constants;

public class BusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer code = Constants.Response.ERROR;

	private String msg;

	public BusException() {
		super();
	}

	public BusException(String message) {
		super(message);
	}

	public BusException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
