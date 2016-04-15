package com.tinysquare.api.news.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tinysquare.api.news.vo.NewsImgVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.dao.entity.NewsImg;
import com.tinysquare.dao.entity.NewsImgExample;
import com.tinysquare.dao.mapper.NewsImgMapper;
import com.tinysquare.tools.DataTools;

@Component
public class NewsImgService {

	@Autowired
	private NewsImgMapper newsImgMapper;

	public List<NewsImg> selectByNewsId(Long newsId) {
		NewsImgExample example = new NewsImgExample();
		example.or().andNewsIdEqualTo(newsId).andStatusEqualTo(Constants.Status.NORMAL);
		return newsImgMapper.selectByExample(example);
	}

	public List<NewsImgVo> selectVoByNewsId(Long newsId) {
		List<NewsImgVo> newsImgVoList = new ArrayList<>();
		List<NewsImg> newsImgList = this.selectByNewsId(newsId);
		newsImgList.forEach((messageImg) -> newsImgVoList.add(new NewsImgVo(messageImg.getId(), messageImg.getUrl())));
		return newsImgVoList;
	}

	public void save(Long newsId, String[] imgs, Date entrydate) {
		this.deleteByNewsId(newsId);
		if (!DataTools.isEmpty(imgs)) {
			List<NewsImg> newsImgList = new ArrayList<>();
			List<String> imgUrlList = Arrays.asList(imgs);
			imgUrlList.stream().filter(img -> !DataTools.isEmpty(img)).forEach((img) -> {
				NewsImg newsImg = new NewsImg();
				newsImg.setNewsId(newsId);
				newsImg.setUrl(img.trim());
				newsImg.setStatus(Constants.Status.NORMAL);
				newsImg.setEntrydate(entrydate);
				newsImgList.add(newsImg);
			});
			if (!CollectionUtils.isEmpty(newsImgList)) {
				this.save(newsImgList);
			}
		}
	}

	public NewsImg save(NewsImg newsImg) {
		if (newsImg.getId() == null) {
			this.newsImgMapper.insertSelective(newsImg);
		} else {
			this.newsImgMapper.updateByPrimaryKeySelective(newsImg);
		}
		return newsImg;
	}

	public List<NewsImg> save(List<NewsImg> newsImgList) {
		newsImgList.forEach((newsImg) -> this.save(newsImg));
		return newsImgList;
	}

	public Integer deleteByNewsId(Long newsId) {
		NewsImgExample example = new NewsImgExample();
		example.or().andNewsIdEqualTo(newsId);
		return this.newsImgMapper.deleteByExample(example);
	}

}
