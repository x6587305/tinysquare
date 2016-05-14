package com.tinysquare.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	public interface Format {

		public final static SimpleDateFormat STANDARD_FORMAT = new SimpleDateFormat("MM-yy HH:mm");

		public final static SimpleDateFormat MILLISECOND_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	}

	/**
	 * 当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 格式化日期,yyyy/MM/dd
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		try {
			return Format.STANDARD_FORMAT.format(date);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 根据format对象格式化
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, SimpleDateFormat format) {
		try {
			return format.format(date);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 根据表达式格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(format(now(), Format.MILLISECOND_FORMAT));
		System.out.println(format(now()));
	}

}
