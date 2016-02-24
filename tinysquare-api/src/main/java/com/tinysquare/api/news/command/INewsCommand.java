package com.tinysquare.api.news.command;

import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

public interface INewsCommand {

	/**
	 * 附近的新闻消息<br>
	 * 根据距离和发布时间排序<br>
	 * 
	 * @param token
	 * @param lng
	 * @param lat
	 * @param pageVo
	 * @return
	 */
	public ResponseVo listByNear(String token, Double lng, Double lat, PageVo pageVo);

	/**
	 * 收藏店铺的新闻消息
	 * 
	 * @param token
	 * @param lng
	 * @param lat
	 * @param pageVo
	 * @return
	 */
	public ResponseVo listByFavorite(String token, Double lng, Double lat, PageVo pageVo);

	/**
	 * 查询店铺发布的新闻消息
	 * 
	 * @param shopId
	 * @param pageVo
	 * @return
	 */
	public ResponseVo listByShop(Long shopId, PageVo pageVo);

	/**
	 * 发布新闻消息
	 * 
	 * @param token
	 * @param content
	 * @param imgs
	 * @return
	 */
	public ResponseVo publish(String token, String content, String[] imgs);

	/**
	 * 更新新闻
	 * 
	 * @param token
	 * @param id
	 * @param content
	 * @param imgs
	 * @return
	 */
	public ResponseVo update(String token, Long id, String content, String[] imgs);

}
