package com.tinysquare.api.user_coupon.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinysquare.api.coupon.service.CouponService;
import com.tinysquare.api.coupon_code.service.CouponCodeService;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.api.user_coupon.command.IUserCouponCommand;
import com.tinysquare.api.user_coupon.service.UserCouponService;
import com.tinysquare.api.user_coupon.vo.UserCouponVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.Coupon;
import com.tinysquare.dao.entity.CouponCode;
import com.tinysquare.dao.entity.UserCoupon;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;

@Service
public class UserCouponCommand implements IUserCouponCommand {

	@Autowired
	private CouponService couponService;
	@Autowired
	private UserCouponService userCouponService;
	@Autowired
	private CouponCodeService couponCodeService;

	@Override
	public ResponseVo list(String token, Byte status, PageVo pageVo) {
		UserVo userVo = UserLocal.get();
		List<UserCouponVo> userCouponVoList = this.userCouponService.selectVoByUserIdAndStatus(userVo.getObjId(), status, pageVo);
		Integer totalCount = this.userCouponService.countByUserIdAndStatus(userVo.getObjId(), status);
		pageVo.setTotalCount(totalCount);
		pageVo.setResult(userCouponVoList);
		return ResponseVo.success(pageVo);
	}

	@Override
	public ResponseVo use(String token, Long id) {
		UserVo userVo = UserLocal.get();
		UserCoupon userCoupon = this.userCouponService.getByPrimaryKey(id);
		if (userCoupon == null || userVo.getObjId() != userCoupon.getUserId()) {
			return ResponseVo.error(Error.ERROR_USER_COUPON_NOT_EXISTS);
		}
		if (userCoupon.getStatus() == Constants.Coupon.USED) {
			return ResponseVo.error(Error.ERROR_USER_COUPON_NOT_EXISTS);
		}
		Coupon coupon = this.couponService.getByPrimaryKey(userCoupon.getCouponId());
		if (coupon == null || Constants.Status.NORMAL != coupon.getStatus() || (coupon.getEndTime() != null && DateTools.now().after(coupon.getEndTime()))) {
			return ResponseVo.error(Error.ERROR_COUPON_INVALID);
		}
		this.userCouponService.used(id);
		return ResponseVo.success();
	}

	@Override
	@Transactional
	public ResponseVo redeem(String token, String code) {
		if (DataTools.isEmpty(code)) {
			return ResponseVo.error(Error.ERROR_COUPON_CODE_EMPTY);
		}
		UserVo userVo = UserLocal.get();
		CouponCode couponCode = couponCodeService.getByCode(code);
		if (couponCode == null) {
			return ResponseVo.error(Error.ERROR_COUPON_CODE_NOT_EXISTS);
		}
		Coupon coupon = this.couponService.getByPrimaryKey(couponCode.getCouponId());
		if (coupon == null || Constants.Status.NORMAL != coupon.getStatus() || (coupon.getEndTime() != null && DateTools.now().after(coupon.getEndTime()))) {
			return ResponseVo.error(Error.ERROR_COUPON_INVALID);
		}
		for (int i = 0; i < couponCode.getQuantity(); i++) {
			UserCoupon userCoupon = new UserCoupon();
			userCoupon.setCouponId(couponCode.getCouponId());
			userCoupon.setUserId(userVo.getObjId());
			userCoupon.setStatus(Constants.Coupon.UNUSE);
			this.userCouponService.save(userCoupon);
		}
		this.couponCodeService.redeem(couponCode);
		return ResponseVo.success();
	}

}
