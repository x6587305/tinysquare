package com.tinysquare.api.vip_card.command;

import com.tinysquare.commons.vo.ResponseVo;

public interface IVipCardCommand {

	/**
	 * 用户会员卡列表
	 * 
	 * @param token
	 * @return
	 */
	public ResponseVo list(String token);

	/**
	 * 设置默认会员卡
	 * 
	 * @param token
	 * @param id
	 * @return
	 */
	public ResponseVo setDefault(String token, Long id);

}
