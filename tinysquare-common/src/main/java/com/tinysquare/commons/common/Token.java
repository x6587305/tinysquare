package com.tinysquare.commons.common;

import com.tinysquare.tools.DateTools;
import com.tinysquare.tools.SecretTools;

public class Token {

	public static String generate(Long userId, String account, String password) {
		return SecretTools.md5(userId + account + password + DateTools.format(DateTools.now(), DateTools.Format.MILLISECOND_FORMAT));
	}

}
