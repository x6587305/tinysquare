package com.tinysquare.front.news.command;

import com.tinysquare.api.news.vo.NewsVo;

public interface INewsFrontCommand {
	
	public NewsVo detail(Long id);

}
