package com.tinysquare.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DataTools {

	public final static DecimalFormat ROUND_FORMAT = new DecimalFormat("0.00");

	/**
	 * 判断字符串是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是空字符串数组
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(String[] value) {
		if (value == null || value.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是空长整型数组
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Long[] value) {
		if (value == null || value.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 格式化BigDecimal,四舍五入保留两位小数
	 * 
	 * @param value
	 * @return
	 */
	public static String format(BigDecimal value) {
		try {
			return ROUND_FORMAT.format(value);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 格式化BigDecimal,四舍五入保留两位小数
	 * 
	 * @param value
	 * @return
	 */
	public static Double format2Double(BigDecimal value) {
		try {
			return Double.valueOf(ROUND_FORMAT.format(value));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 格式化Double,四舍五入保留两位小数
	 * 
	 * @param value
	 * @return
	 */
	public static String format(Double value) {
		try {
			return ROUND_FORMAT.format(value);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 格式化Double,四舍五入保留两位小数
	 * 
	 * @param value
	 * @return
	 */
	public static Double format2Double(Double value) {
		try {
			return Double.valueOf(ROUND_FORMAT.format(value));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 乘法
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double multiply(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2).doubleValue();
	}

	/**
	 * 乘法
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double multiply(Double value1, Double value2) {
		return new BigDecimal(Double.toString(value1)).multiply(new BigDecimal(Double.toString(value2))).doubleValue();
	}

	/**
	 * 除法
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double divide(BigDecimal value1, BigDecimal value2) {
		return value1.divide(value2).doubleValue();
	}

	/**
	 * 除法
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double divide(Double value1, Double value2) {
		return new BigDecimal(Double.toString(value1)).divide(new BigDecimal(Double.toString(value2))).doubleValue();
	}

}
