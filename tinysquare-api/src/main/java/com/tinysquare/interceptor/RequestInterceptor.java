package com.tinysquare.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tinysquare.api.user.command.IUserCommand;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.common.Sign;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.enums.Platform;
import com.tinysquare.commons.exception.BusException;
import com.tinysquare.commons.vo.RequestVo;
import com.tinysquare.threadlocal.RequestLocal;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.LoggerTools;

public class RequestInterceptor implements HandlerInterceptor {

	private final static List<String> SECURITY_URL_LIST = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;

		{
			add("newsFront/detail");
		}
	};

	private static Logger logger = Logger.getLogger(RequestInterceptor.class);

	@Autowired
	private IUserCommand userCommand;

	@Override
	public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object object) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String platform = request.getParameter(Constants.Params.PLATFORM);
		String token = request.getParameter(Constants.Params.TOKEN);
		String version = request.getParameter(Constants.Params.VERSION);
		String sign = request.getParameter(Constants.Params.SIGN);
		String url = request.getRequestURI();
		if (!this.isSecurityUrl(url)) {
			this.apiValid(platform, sign, token, version, request);
		}
		this.bulidRequest(platform, sign, token, version, url);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object object, ModelAndView model) throws Exception {
		this.clear();
	}

	@Override
	public void afterCompletion(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object object, Exception e) throws Exception {
		this.clear();
	}

	private void clear() {
		UserLocal.remove();
		RequestLocal.remove();
	}

	private boolean isSecurityUrl(String url) {
		for (String securityUrl : SECURITY_URL_LIST) {
			int index = url.indexOf(securityUrl);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}

	private void apiValid(String platform, String sign, String token, String version, HttpServletRequest request) {
		Byte platformValue = Platform.getValue(platform);
		if (platformValue == null) {
			throw new BusException(Error.ERROR_PLATFORM);
		}
		// 验证签名
		if (DataTools.isEmpty(sign) || !Sign.validate(request)) {
			throw new BusException(Error.ERROR_SIGN);
		}
		// 验证token
		if (!DataTools.isEmpty(token)) {
			UserVo userVo = this.userCommand.getByToken(token);
			UserLocal.set(userVo);
		}
	}

	private void bulidRequest(String platform, String sign, String token, String version, String url) {
		RequestVo requestVo = new RequestVo(Platform.getValue(platform), token, version, sign);
		RequestLocal.set(requestVo);
		String message = url + " " + requestVo;
		LoggerTools.debug(logger, message);
	}

}
