package com.tinysquare.api.user_coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.user_coupon.command.IUserCouponCommand;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/userCoupon")
public class UseCouponController {

	@Autowired
	private IUserCouponCommand userCouponCommand;

	/**
	 * 我的优惠券
	 * 
	 * @param token
	 * @param status
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseVo list(@RequestParam(required = true) String token, @RequestParam(required = true) Byte status,
			@RequestParam(required = true) Integer pageNum, @RequestParam(required = true) Integer pageSize) {
		ResponseVo reponseVo = userCouponCommand.list(token, status, new PageVo(pageNum, pageSize));
		return reponseVo;
	}

	/**
	 * 使用
	 * 
	 * @param token
	 * @param userCouponId
	 * @return
	 */
	@RequestMapping(value = "/use", method = RequestMethod.POST)
	public ResponseVo user(@RequestParam(required = true) String token, @RequestParam(required = true) Long id) {
		ResponseVo reponseVo = userCouponCommand.use(token, id);
		return reponseVo;
	}

	/**
	 * 兑换
	 * 
	 * @param token
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/redeem", method = RequestMethod.POST)
	public ResponseVo redeem(@RequestParam(required = true) String token, @RequestParam(required = true) String code) {
		ResponseVo reponseVo = userCouponCommand.redeem(token, code);
		return reponseVo;
	}

}
