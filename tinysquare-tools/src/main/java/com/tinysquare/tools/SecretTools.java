package com.tinysquare.tools;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecretTools {

	private final static String MD5 = "MD5";

	private final static String ENCODING = "UTF-8";

	/**
	 * md5加密
	 * 
	 * @param string
	 * @return
	 */
	public static String md5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			md.update(string.getBytes(ENCODING));
			byte[] b = md.digest();
			return bytes2HexString(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytes2HexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sb.append("0");
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * 16进制字符串转换成byte数组
	 * 
	 * @param string
	 * @return
	 */
	public static byte[] hexString2byte(String string) {
		try {
			byte[] bytes = string.getBytes(ENCODING);
			if ((bytes.length % 2) != 0) {
				return null;
			}
			byte[] temp = new byte[bytes.length / 2];
			for (int n = 0; n < bytes.length; n += 2) {
				String item = new String(bytes, n, 2);
				temp[n / 2] = (byte) Integer.parseInt(item, 16);
			}
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 可逆加密
	 * 
	 * @param data
	 * @param key
	 * @param name
	 * @return
	 */
	public static String encrypt(String data, String key, String name) {
		try {
			return bytes2HexString(encrypt(data.getBytes(), key.getBytes(ENCODING), name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 可逆解密
	 * 
	 * @param data
	 * @param key
	 * @param name
	 * @return
	 */
	public static String decrypt(String data, String key, String name) {
		try {
			return new String(decrypt(hexString2byte(data), key.getBytes(ENCODING), name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] encrypt(byte[] src, byte[] key, String name) throws Exception {
		SecretKeySpec securekey = new SecretKeySpec(key, name);
		Cipher cipher = Cipher.getInstance(name);
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		return cipher.doFinal(src);
	}

	private static byte[] decrypt(byte[] src, byte[] key, String name) throws Exception {
		SecretKeySpec securekey = new SecretKeySpec(key, name);
		Cipher cipher = Cipher.getInstance(name);
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		return cipher.doFinal(src);
	}

	public static void main(String[] args) {
		String a = encrypt("aaaabbbb", "20160201", "DES");
		System.out.println(a);
		String b = decrypt(a, "20160201", "DES");
		System.out.println(b);
	}
}
