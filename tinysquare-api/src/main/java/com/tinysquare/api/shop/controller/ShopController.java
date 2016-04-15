package com.tinysquare.api.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.shop.command.IShopCommand;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private IShopCommand shopCommand;

	/**
	 * 店铺详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public ResponseVo detail(@RequestParam(required = true) Long id) {
		ResponseVo responseVo = this.shopCommand.detail(id);
		return responseVo;
	}

	/**
	 * 更新
	 * 
	 * @param token
	 * @param avator
	 * @param name
	 * @param tel
	 * @param brief
	 * @param address
	 * @param imgs
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseVo update(@RequestParam(required = true) String token, @RequestParam(required = false) String avator,
			@RequestParam(required = false) String name, @RequestParam(required = false) String tel, @RequestParam(required = true) String brief,
			@RequestParam(required = true) String address, @RequestParam(required = false) String[] imgs) {
		ResponseVo responseVo = this.shopCommand.update(token, avator, name, tel, brief, address, imgs);
		return responseVo;
	}

	/**
	 * 修改店铺名称
	 * 
	 * @param token
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/updateName", method = RequestMethod.POST)
	public ResponseVo updateName(@RequestParam(required = true) String token, @RequestParam(required = true) String name) {
		ResponseVo responseVo = this.shopCommand.updateName(token, name);
		return responseVo;
	}

	/**
	 * 修改店铺电话
	 * 
	 * @param token
	 * @param tel
	 * @return
	 */
	@RequestMapping(value = "/updateTel", method = RequestMethod.POST)
	public ResponseVo updateTel(@RequestParam(required = true) String token, @RequestParam(required = true) String tel) {
		ResponseVo responseVo = this.shopCommand.updateTel(token, tel);
		return responseVo;
	}

	/**
	 * 修改店铺简介
	 * 
	 * @param token
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/updateBrief", method = RequestMethod.POST)
	public ResponseVo updateBrief(@RequestParam(required = true) String token, @RequestParam(required = true) String brief) {
		ResponseVo responseVo = this.shopCommand.updateBrief(token, brief);
		return responseVo;
	}

	/**
	 * 修改店铺地址
	 * 
	 * @param token
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public ResponseVo updateAddress(@RequestParam(required = true) String token, @RequestParam(required = true) String address) {
		ResponseVo responseVo = this.shopCommand.updateAddress(token, address);
		return responseVo;
	}

	/**
	 * 修改店铺头像
	 * 
	 * @param token
	 * @param avator
	 * @return
	 */
	@RequestMapping(value = "/updateAvator", method = RequestMethod.POST)
	public ResponseVo updateAvatar(@RequestParam(required = true) String token, @RequestParam(required = true) String avator) {
		ResponseVo responseVo = this.shopCommand.updateAvator(token, avator);
		return responseVo;
	}

	/**
	 * 修改店铺照片
	 * 
	 * @param token
	 * @param imgs
	 *            店铺的全部图片地址
	 * @return
	 */
	@RequestMapping(value = "/updateImgs", method = RequestMethod.POST)
	public ResponseVo updateImgs(@RequestParam(required = true) String token, @RequestParam(required = true) String[] imgs) {
		ResponseVo responseVo = this.shopCommand.updateImgs(token, imgs);
		return responseVo;
	}

}
