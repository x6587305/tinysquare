package com.tinysquare.threadlocal;

import com.tinysquare.api.user.vo.UserVo;

public class UserLocal {

	private final static UserVo DEFAULT = new UserVo();

	private static ThreadLocal<UserVo> theadLocal = new ThreadLocal<>();

	public static UserVo get() {
		UserVo userVo = theadLocal.get();
		if (userVo == null) {
			return DEFAULT;
		}
		return userVo;
	}

	public static void set(UserVo userVo) {
		theadLocal.set(userVo);
	}

	public static void remove() {
		theadLocal.remove();
	}
}
