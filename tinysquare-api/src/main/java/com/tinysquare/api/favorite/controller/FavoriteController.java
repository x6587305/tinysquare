package com.tinysquare.api.favorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.favorite.command.IFavoriteCommand;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

	@Autowired
	private IFavoriteCommand favoriteCommand;

	/**
	 * 收藏店铺
	 * 
	 * @param token
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "/addShop", method = RequestMethod.POST)
	public ResponseVo addShop(@RequestParam(required = true) String token, @RequestParam(required = true) Long shopId) {
		ResponseVo responseVo = this.favoriteCommand.addShop(token, shopId);
		return responseVo;
	}

	/**
	 * 取消收藏店铺
	 * 
	 * @param token
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "/cancelShop", method = RequestMethod.POST)
	public ResponseVo cancelShop(@RequestParam(required = true) String token, @RequestParam(required = true) Long shopId) {
		ResponseVo responseVo = this.favoriteCommand.cancelShop(token, shopId);
		return responseVo;
	}

}
