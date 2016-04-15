package com.tinysquare.api.user_coupon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.api.user_coupon.vo.UserCouponVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.dao.entity.UserCoupon;
import com.tinysquare.dao.entityex.UserCouponItem;
import com.tinysquare.dao.mapper.UserCouponMapper;
import com.tinysquare.tools.DateTools;

@Component
public class UserCouponService {

	@Autowired
	private UserCouponMapper userCouponMapper;

	public UserCoupon getByPrimaryKey(Long id) {
		return this.userCouponMapper.selectByPrimaryKey(id);
	}

	public List<UserCouponItem> selectByUserIdAndStatus(Long userId, Byte status, PageVo pageVo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("status", status);
		params.put("pageBegin", pageVo.getPageBegin());
		params.put("pageSize", pageVo.getPageSize());
		return this.userCouponMapper.selectByUserIdAndStatus(params);
	}

	public List<UserCouponVo> selectVoByUserIdAndStatus(Long userId, Byte status, PageVo pageVo) {
		List<UserCouponVo> userCouponVoList = new ArrayList<>();
		List<UserCouponItem> userCouponItemList = selectByUserIdAndStatus(userId, status, pageVo);
		userCouponItemList.forEach((userCouponItem) -> userCouponVoList.add(new UserCouponVo(userCouponItem.getId(), null, userCouponItem.getCouponId(),
				userCouponItem.getStatus(), DateTools.format(userCouponItem.getEntrydate()), userCouponItem.getShopId(), userCouponItem.getShopName(),
				userCouponItem.getCouponName(), userCouponItem.getCouponImg(), userCouponItem.getCategory(), userCouponItem.getAmount(),
				DateTools.format(userCouponItem.getStartTime()), DateTools.format(userCouponItem.getEndTime()))));
		return userCouponVoList;
	}

	public Integer countByUserIdAndStatus(Long userId, Byte status) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("status", status);
		return this.userCouponMapper.countByUserIdAndStatus(params);
	}

	public Integer used(Long id) {
		UserCoupon userCoupon = new UserCoupon();
		userCoupon.setId(id);
		userCoupon.setStatus(Constants.Coupon.USED);
		return this.userCouponMapper.updateByPrimaryKeySelective(userCoupon);
	}

	public UserCoupon save(UserCoupon userCoupon) {
		if (userCoupon.getId() == null) {
			this.userCouponMapper.insertSelective(userCoupon);
		} else {
			this.userCouponMapper.updateByPrimaryKeySelective(userCoupon);
		}
		return userCoupon;
	}

}
