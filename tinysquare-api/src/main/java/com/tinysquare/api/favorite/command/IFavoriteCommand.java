package com.tinysquare.api.favorite.command;

import com.tinysquare.commons.vo.ResponseVo;

public interface IFavoriteCommand {

	/**
	 * 收藏店铺
	 * 
	 * @param token
	 * @param shopId
	 * @return
	 */
	public ResponseVo addShop(String token, Long shopId);

	/**
	 * 取消收藏店铺
	 * 
	 * @param token
	 * @param shopId
	 * @return
	 */
	public ResponseVo cancelShop(String token, Long shopId);

}
