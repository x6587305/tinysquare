package com.tinysquare.api.news.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.news.command.INewsCommand;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/news")
public class NewsController {

	private static Logger LOGGER = Logger.getLogger(NewsController.class);

	@Autowired
	private INewsCommand newsCommand;

	/**
	 * 最近的新闻消息
	 * 
	 * @param token
	 * @param lng
	 * @param lat
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/listByNear", method = RequestMethod.POST)
	public ResponseVo listByNear(@RequestParam(required = false) String token, @RequestParam(required = true) Double lng,
			@RequestParam(required = true) Double lat, @RequestParam(required = true) Integer pageNum, @RequestParam(required = true) Integer pageSize) {
		LOGGER.info("lng:" + lng + ",lat:" + lat);
		ResponseVo responseVo = this.newsCommand.listByNear(token, lng, lat, new PageVo(pageNum, pageSize));
		return responseVo;
	}

	/**
	 * 收藏店铺的新闻消息
	 * 
	 * @param token
	 * @param lng
	 * @param lat
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/listByFavorite", method = RequestMethod.POST)
	public ResponseVo listByFavorite(@RequestParam(required = true) String token, @RequestParam(required = true) Double lng,
			@RequestParam(required = true) Double lat, @RequestParam(required = true) Integer pageNum, @RequestParam(required = true) Integer pageSize) {
		ResponseVo responseVo = this.newsCommand.listByFavorite(token, lng, lat, new PageVo(pageNum, pageSize));
		return responseVo;
	}

	/**
	 * 查询店铺的新闻消息
	 * 
	 * @param shopId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/listByShop", method = RequestMethod.POST)
	public ResponseVo listByShop(@RequestParam(required = true) Long shopId, @RequestParam(required = true) Integer pageNum,
			@RequestParam(required = true) Integer pageSize) {
		ResponseVo responseVo = this.newsCommand.listByShop(shopId, new PageVo(pageNum, pageSize));
		return responseVo;
	}

	/**
	 * 发布新闻
	 * 
	 * @param token
	 * @param content
	 * @param imgs
	 * @return
	 */
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public ResponseVo publish(@RequestParam(required = true) String token, @RequestParam(required = true) String content,
			@RequestParam(required = false) String[] imgs) {
		ResponseVo responseVo = this.newsCommand.publish(token, content.trim(), imgs);
		return responseVo;
	}

	/**
	 * 更新新闻
	 * 
	 * @param token
	 * @param newsId
	 * @param content
	 * @param imgs
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseVo update(@RequestParam(required = true) String token, @RequestParam(required = true) Long newsId,
			@RequestParam(required = true) String content, @RequestParam(required = false) String[] imgs) {
		ResponseVo responseVo = this.newsCommand.update(token, newsId, content.trim(), imgs);
		return responseVo;
	}

}
