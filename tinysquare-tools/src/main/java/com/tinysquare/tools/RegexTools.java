package com.tinysquare.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTools {

	/**
	 * 验证是否是数字字母
	 * 
	 * @param string
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isWordAndNum(String string, int min, int max) {
		String regex = "^[a-zA-Z0-9]{" + min + "," + max + "}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
	}

	/**
	 * 验证是否是数字字母符号
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isWordAndNumAndPunctuation(String string, int min, int max) {
		String regex = "^(?![a-zA-Z0-9]+$)(?![^a-zA-Z/D]+$)(?![^0-9/D]+$).{" + min + "," + max + "}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
	}

	/**
	 * 验证是否是中文
	 * 
	 * @param account
	 * @return
	 */
	public static boolean isChinese(String str) {
		String regex = "[\u4e00-\u9fa5a-zA-z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 验证是否是数字字母
	 * 
	 * @param string
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isMobile(String string) {
		String regex = "^[0-9]{11}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		return m.matches();
	}

	/**
	 * 验证是否是邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String regex = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static void main(String[] args) {
		System.out.println(isMobile("1111111111"));
	}

}
