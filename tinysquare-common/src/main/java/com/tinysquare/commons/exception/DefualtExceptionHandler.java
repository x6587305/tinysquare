package com.tinysquare.commons.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.ResponseVo;

@ControllerAdvice
public class DefualtExceptionHandler {

	protected static Logger logger = Logger.getLogger(DefualtExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseVo handlerException(NativeWebRequest request, Exception e) {
		if (e instanceof BusException) {
			return ResponseVo.error(e.getMessage());
		}
		logger.error(e.getMessage());
		return ResponseVo.error(Error.ERROR_API, e.getMessage());
	}

}
