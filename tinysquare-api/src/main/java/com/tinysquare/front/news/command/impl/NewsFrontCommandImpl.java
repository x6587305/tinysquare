package com.tinysquare.front.news.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.news.service.NewsImgService;
import com.tinysquare.api.news.service.NewsService;
import com.tinysquare.api.news.vo.NewsVo;
import com.tinysquare.api.shop.service.ShopService;
import com.tinysquare.dao.entity.Shop;
import com.tinysquare.front.news.command.INewsFrontCommand;

@Service
public class NewsFrontCommandImpl implements INewsFrontCommand {

	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsImgService newsImgService;
	@Autowired
	private ShopService shopService;

	@Override
	public NewsVo detail(Long id) {
		NewsVo newsVo = this.newsService.getVoByPrimaryKey(id);
		if (newsVo == null) {
			return null;
		}
		newsVo.setImgs(this.newsImgService.selectVoByNewsId(newsVo.getObjId()));
		Shop shop = shopService.getByPrimaryKey(newsVo.getShopId());
		if (shop != null) {
			newsVo.setShopName(shop.getName());
			newsVo.setAvator(shop.getAvator());
		} else {
			newsVo.setShopName("");
			newsVo.setAvator("");
		}
		return newsVo;
	}

}
