package com.tinysquare.api.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.message.command.IMessageCommand;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private IMessageCommand messageCommand;

	/**
	 * 系统消息列表
	 * 
	 * @param token
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public ResponseVo get(@RequestParam(required = true) String token, @RequestParam(required = true) Long id) {
		ResponseVo responseVo = this.messageCommand.get(token, id);
		return responseVo;
	}

	/**
	 * 系统消息列表
	 * 
	 * @param token
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseVo list(@RequestParam(required = true) String token, @RequestParam(required = true) Integer pageNum,
			@RequestParam(required = true) Integer pageSize) {
		ResponseVo responseVo = this.messageCommand.list(token, new PageVo(pageNum, pageSize));
		return responseVo;
	}

}
