package com.tinysquare.api.news.command.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinysquare.api.favorite.service.FavoriteService;
import com.tinysquare.api.news.command.INewsCommand;
import com.tinysquare.api.news.service.NewsImgService;
import com.tinysquare.api.news.service.NewsService;
import com.tinysquare.api.news.vo.NewsVo;
import com.tinysquare.api.shop.service.ShopService;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.News;
import com.tinysquare.dao.entity.Shop;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;

@Service
public class NewsCommand implements INewsCommand {

	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsImgService newsImgService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private FavoriteService favoriteService;

	@Override
	public ResponseVo listByNear(String token, Double lng, Double lat, PageVo pageVo) {
		if (lng == null || lat == null) {
			return ResponseVo.error(Error.ERROR_FAILURE_LOCATION);
		}
		List<NewsVo> newsVoList = this.newsService.selectVoOrderByDistance(lng, lat, pageVo);
		newsVoList.forEach((newsVo) -> {
			newsVo.setImgs(this.newsImgService.selectVoByNewsId(newsVo.getObjId()));
			newsVo.setNewShare();
		});
		// 判断用户是否已经收藏
		UserVo userVo = UserLocal.get();
		if (!DataTools.isEmpty(token) && userVo != null) {
			List<Long> shopIdList = new ArrayList<>();
			newsVoList.forEach((newsVo) -> shopIdList.add(newsVo.getShopId()));
			Set<Long> favoriteShopIdSet = this.favoriteService.selectShopIdByUserIdAndShopIdList(userVo.getObjId(), shopIdList);
			newsVoList.stream().filter((newsVo) -> !favoriteShopIdSet.contains(newsVo.getShopId()))
					.forEach((newsVo) -> newsVo.setCanFavorite(Constants.Boolean.TRUE));
		}
		Integer totalCount = this.newsService.countOrderByDistance();
		pageVo.setTotalCount(totalCount);
		pageVo.setResult(newsVoList);
		return ResponseVo.success(pageVo);
	}

	@Override
	public ResponseVo listByFavorite(String token, Double lng, Double lat, PageVo pageVo) {
		if (lng == null || lat == null) {
			return ResponseVo.error(Error.ERROR_FAILURE_LOCATION);
		}
		UserVo userVo = UserLocal.get();
		List<NewsVo> newsVoList = this.newsService.selectVoByFavorite(userVo.getObjId(), lng, lat, pageVo);
		newsVoList.forEach((newsVo) -> {
			newsVo.setImgs(this.newsImgService.selectVoByNewsId(newsVo.getObjId()));
			newsVo.setNewShare();
		});
		Integer totalCount = this.newsService.countByFavorite(userVo.getObjId());
		pageVo.setTotalCount(totalCount);
		pageVo.setResult(newsVoList);
		return ResponseVo.success(pageVo);
	}

	@Override
	public ResponseVo listByShop(Long shopId, PageVo pageVo) {
		List<NewsVo> newsVoList = newsService.selectVoByShopId(shopId, pageVo);
		newsVoList.forEach((newsVo) -> {
			newsVo.setImgs(this.newsImgService.selectVoByNewsId(newsVo.getObjId()));
			newsVo.setNewShare();
		});
		Integer totalCount = this.newsService.countByShopId(shopId);
		pageVo.setTotalCount(totalCount);
		pageVo.setResult(newsVoList);
		return ResponseVo.success(pageVo);
	}

	@Override
	@Transactional
	public ResponseVo publish(String token, String content, String[] imgs) {
		UserVo userVo = UserLocal.get();
		if (Constants.User.USER_CATEGORY_SHOP != userVo.getCategory()) {
			return ResponseVo.error(Error.ERROR_SHOP_EDIT_AUTH);
		}
		Shop shop = shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_CREATE);
		}
		Date now = DateTools.now();
		News news = new News();
		news.setTitle("");
		news.setContent(content);
		news.setShopId(shop.getId());
		news.setStatus(Constants.Status.NORMAL);
		news.setEntrydate(now);
		String error = this.newsService.check(news);
		if (error != null) {
			return ResponseVo.error(error);
		}
		this.newsService.historyByShopId(shop.getId());
		this.newsService.save(news);
		this.newsImgService.save(news.getId(), imgs, now);
		return ResponseVo.success();
	}

	@Override
	@Transactional
	public ResponseVo update(String token, Long id, String content, String[] imgs) {
		UserVo userVo = UserLocal.get();
		if (Constants.User.USER_CATEGORY_SHOP != userVo.getCategory()) {
			return ResponseVo.error(Error.ERROR_SHOP_EDIT_AUTH);
		}
		Shop shop = shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_CREATE);
		}
		News news = this.newsService.getByPrimaryKey(id);
		if (news == null) {
			return ResponseVo.error(Error.ERROR_NEWS_NOT_EXISTS);
		}
		if (Constants.Status.NORMAL != news.getStatus()) {
			return ResponseVo.error(Error.ERROR_NEW_EDIT_STATUS);
		}
		Date now = DateTools.now();
		news.setContent(content);
		news.setStatus(Constants.Status.NORMAL);
		news.setEntrydate(now);
		String error = this.newsService.check(news);
		if (error != null) {
			return ResponseVo.error(error);
		}
		this.newsService.historyByShopId(shop.getId());
		this.newsService.save(news);
		this.newsImgService.save(news.getId(), imgs, now);
		return ResponseVo.success();
	}

}
