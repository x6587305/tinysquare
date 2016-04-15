package com.tinysquare.api.user_coupon.command;

import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;

public interface IUserCouponCommand {

	/**
	 * 我的优惠券
	 * 
	 * @param token
	 * @param status
	 * @param pageVo
	 * @return
	 */
	public ResponseVo list(String token, Byte status, PageVo pageVo);

	/**
	 * 使用优惠券
	 * 
	 * @param token
	 * @param id
	 * @return
	 */
	public ResponseVo use(String token, Long id);

	/**
	 * 兑换优惠券
	 * 
	 * @param token
	 * @param code
	 * @return
	 */
	public ResponseVo redeem(String token, String code);

}
