package com.tinysquare.commons.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.SecretTools;

public class Sign {

	protected static Logger logger = Logger.getLogger(Sign.class);

	public static boolean validate(HttpServletRequest request) {
		String remoteSign = request.getParameter(Constants.Params.SIGN);
		String localSign = sign(request.getParameterMap());
		//LoggerTools.debug(logger, "sign validate request params:" + getParamMapValue(request.getParameterMap()));
		//LoggerTools.debug(logger, "sign validate remoteSign=" + remoteSign + ",localSign=" + localSign);
		return localSign.equals(remoteSign);
	}

	public static String sign(Map<String, String[]> params) {
		if (CollectionUtils.isEmpty(params)) {
			return null;
		}
		Map<String, String> map = new TreeMap<String, String>();
		params.entrySet().forEach((entry) -> {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (!DataTools.isEmpty(values)) {
				map.put(key, getValues(values));
			}
		});
		StringBuilder sb = new StringBuilder();
		map.entrySet().stream().filter((entry) -> !entry.getKey().equals(Constants.Params.SIGN))
				.forEach((entry) -> sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&"));
		sb.append(Constants.SIGN_SECRET);
		return SecretTools.md5(sb.toString());
	}

	private static String getValues(String[] values) {
		if (values.length == 1) {
			return values[0];
		}
		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append(value);
		}
		return sb.toString();
	}

	protected static String getParamMapValue(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		map.entrySet().stream().forEach((entry) -> sb.append(entry.getKey()).append("=").append(getValues(entry.getValue())).append("&"));
		return sb.toString();
	}

	public static void main(String[] args) {
		Map<String, String[]> params = new HashMap<String, String[]>();
		params.put("account", new String[] { "yuqian" });
		params.put("password", new String[] { "123456" });
		params.put("email", new String[] { "11111" });
		System.out.println("sign:" + sign(params));
	}
}
