package com.tinysquare.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.tinysquare.constants.Constants;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.LoggerTools;
import com.tinysquare.tools.SecretTools;

public class Sign {

	private static Logger logger = Logger.getLogger(Sign.class);

	public static boolean validate(HttpServletRequest request) {
		String sign = request.getParameter(Constants.Params.SIGN);
		String $sign = sign(request.getParameterMap());
		LoggerTools.debug(logger, "sign:" + sign + ",$sign:" + $sign);
		return $sign.equals(sign);
	}

	public static String sign(Map<String, String[]> params) {
		if (CollectionUtils.isEmpty(params)) {
			return null;
		}
		Map<String, String> map = new TreeMap<String, String>();
		params.entrySet().forEach((entry) -> {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (!DataTools.isEmpty(values) && !StringUtils.isEmpty(values[0])) {
				map.put(key, values[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		map.entrySet().parallelStream().filter((entry) -> !entry.getKey().equals(Constants.Params.SIGN))
				.forEach((entry) -> {
					LoggerTools.debug(logger, entry.getKey() + ":" + entry.getValue());
					sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				});
		return SecretTools.md5(sb.toString());
	}

	public static void main(String[] args) {
		Map<String, String[]> param = new HashMap<String, String[]>();
		param.put("platform", new String[] { "sdfdsafsdaf" });
		param.put("account", new String[] { "sdfdsafsdaf" });
		param.put("password", new String[] { "sdfdsafsdaf" });
		System.out.println("sign:" + sign(param));
	}
}
