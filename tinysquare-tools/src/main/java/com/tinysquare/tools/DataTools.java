package com.tinysquare.tools;

public class DataTools {

	/**
	 * 判断是否为null
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		return object == null ? true : false;
	}

	/**
	 * 判断是否是空字符串数组
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(String[] array) {
		if (isNull(array) || array.length == 0) {
			return true;
		}
		return false;
	}

}
