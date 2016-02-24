package com.tinysquare.api.vip_card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.vip_card.command.IVipCardCommand;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/vipCard")
public class VipCardController {

	@Autowired
	private IVipCardCommand vipCardCommand;

	/**
	 * 会员卡列表
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseVo list(@RequestParam(required = true) String token) {
		ResponseVo responseVo = this.vipCardCommand.list(token);
		return responseVo;
	}

	/**
	 * 设置默认
	 * 
	 * @param token
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/setDefault", method = RequestMethod.POST)
	public ResponseVo setDefault(@RequestParam(required = true) String token, @RequestParam(required = true) Long id) {
		ResponseVo responseVo = this.vipCardCommand.setDefault(token, id);
		return responseVo;
	}

}
