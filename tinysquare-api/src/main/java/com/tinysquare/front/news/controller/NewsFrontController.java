package com.tinysquare.front.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tinysquare.api.news.vo.NewsVo;
import com.tinysquare.front.news.command.INewsFrontCommand;

@Controller
@RequestMapping("/newsFront")
public class NewsFrontController {

	@Autowired
	private INewsFrontCommand newsFrontCommand;

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model) {
		NewsVo newsVo = newsFrontCommand.detail(id);
		model.addAttribute("news", newsVo);
		return "news/detail";
	}
}
