package com.tinysquare.api.message.command;

import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

public interface IMessageCommand {

	/**
	 * 系统消息列表
	 * 
	 * @param token
	 * @param pageVo
	 * @return
	 */
	public ResponseVo list(String token, PageVo pageVo);

}
