package com.tinysquare.api.message.command;

import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

public interface IMessageCommand {
	
	/**
	 * 主键查询
	 * 
	 * @param token
	 * @param id
	 * @return
	 */
	public ResponseVo get(String token, Long id);

	/**
	 * 系统消息列表
	 * 
	 * @param token
	 * @param pageVo
	 * @return
	 */
	public ResponseVo list(String token, PageVo pageVo);


}
