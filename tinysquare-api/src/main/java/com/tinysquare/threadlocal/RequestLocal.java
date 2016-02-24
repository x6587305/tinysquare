package com.tinysquare.threadlocal;

import com.tinysquare.commons.vo.RequestVo;

public class RequestLocal {

	private final static RequestVo DEFAULT = new RequestVo();

	private static ThreadLocal<RequestVo> theadLocal = new ThreadLocal<>();

	public static RequestVo get() {
		RequestVo requestVo = theadLocal.get();
		if (requestVo == null) {
			return DEFAULT;
		}
		return requestVo;
	}

	public static void set(RequestVo requestVo) {
		theadLocal.set(requestVo);
	}

	public static void remove() {
		theadLocal.remove();
	}

}
