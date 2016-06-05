package com.tinysquare.api.news.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.api.news.vo.NewsVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.dao.entity.News;
import com.tinysquare.dao.entity.NewsExample;
import com.tinysquare.dao.entityex.NewsItem;
import com.tinysquare.dao.mapper.NewsMapper;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;

@Component
public class NewsService {

	@Autowired
	private NewsMapper newsMapper;

	public News getByPrimaryKey(Long id) {
		return this.newsMapper.selectByPrimaryKey(id);
	}

	public NewsVo getVoByPrimaryKey(Long id) {
		News news = this.getByPrimaryKey(id);
		if (news == null) {
			return null;
		}
		return new NewsVo(news.getId(), null, news.getContent(), news.getShopId(), DateTools.format(news.getEntrydate()), null, null, null);
	}

	public List<NewsItem> selectOrderByDistance(Double lng, Double lat, PageVo pageVo) {
		Map<String, Object> params = new HashMap<>();
		params.put("lng", lng);
		params.put("lat", lat);
		params.put("pageBegin", pageVo.getPageBegin());
		params.put("pageSize", pageVo.getPageSize());
		return this.newsMapper.selectOrderByDistance(params);
	}

	public List<NewsVo> selectVoOrderByDistance(Double lng, Double lat, PageVo pageVo) {
		List<NewsVo> newsVoList = new ArrayList<>();
		List<NewsItem> newsItemList = this.selectOrderByDistance(lng, lat, pageVo);
		newsItemList.forEach((newsItem) -> newsVoList.add(new NewsVo(newsItem.getId(), newsItem.getShopName(), newsItem.getContent(), newsItem.getShopId(),
				DateTools.format(newsItem.getEntrydate()), newsItem.getAvator(), newsItem.getFavoriteCount(), DataTools.getDistance(newsItem.getDistance()))));
		return newsVoList;
	}

	public Integer countOrderByDistance() {
		return this.newsMapper.countOrderByDistance(null);
	}

	public List<NewsItem> selectByFavorite(Long userId, Double lng, Double lat, PageVo pageVo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("lng", lng);
		params.put("lat", lat);
		params.put("pageBegin", pageVo.getPageBegin());
		params.put("pageSize", pageVo.getPageSize());
		return this.newsMapper.selectByFavorite(params);
	}

	public List<NewsVo> selectVoByFavorite(Long userId, Double lng, Double lat, PageVo pageVo) {
		List<NewsVo> newsVoList = new ArrayList<>();
		List<NewsItem> newsItemList = this.selectByFavorite(userId, lng, lat, pageVo);
		newsItemList.forEach((newsItem) -> newsVoList.add(new NewsVo(newsItem.getId(), newsItem.getShopName(), newsItem.getContent(), newsItem.getShopId(),
				DateTools.format(newsItem.getEntrydate()), newsItem.getAvator(), newsItem.getFavoriteCount(), DataTools.getDistance(newsItem.getDistance()))));
		return newsVoList;
	}

	public Integer countByFavorite(Long userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return this.newsMapper.countByFavorite(params);
	}

	public List<NewsItem> selectByShopId(Long shopId, PageVo pageVo) {
		Map<String, Object> params = new HashMap<>();
		params.put("shopId", shopId);
		params.put("pageBegin", pageVo.getPageBegin());
		params.put("pageSize", pageVo.getPageSize());
		return this.newsMapper.selectByShopId(params);
	}

	public List<NewsVo> selectVoByShopId(Long shopId, PageVo pageVo) {
		List<NewsVo> newsVoList = new ArrayList<>();
		List<NewsItem> newsItemList = this.selectByShopId(shopId, pageVo);
		newsItemList.forEach((newsItem) -> newsVoList.add(new NewsVo(newsItem.getId(), newsItem.getShopName(), newsItem.getContent(), newsItem.getShopId(),
				DateTools.format(newsItem.getEntrydate()), newsItem.getAvator(), null, null, newsItem.getStatus())));
		return newsVoList;
	}

	public Integer countByShopId(Long shopId) {
		Map<String, Object> params = new HashMap<>();
		params.put("shopId", shopId);
		return this.newsMapper.countByShopId(params);
	}

	public String check(News news) {
		if (DataTools.isEmpty(news.getContent())) {
			return Error.ERROR_CONTENT_EMPTY;
		}
		news.setContent(news.getContent().trim());
		if (news.getContent().length() > 200) {
			return Error.ERROR_CONTENT_LENGTH;
		}
		return null;
	}

	public News save(News news) {
		if (news.getId() == null) {
			this.newsMapper.insertSelective(news);
		} else {
			this.newsMapper.updateByPrimaryKeySelective(news);
		}
		return news;
	}

	public Integer historyByShopId(Long shopId) {
		NewsExample example = new NewsExample();
		example.or().andShopIdEqualTo(shopId).andStatusEqualTo(Constants.Status.NORMAL);
		News news = new News();
		news.setStatus(Constants.Status.HISTORY);
		return this.newsMapper.updateByExampleSelective(news, example);
	}

}
