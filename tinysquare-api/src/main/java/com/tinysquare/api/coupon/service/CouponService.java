package com.tinysquare.api.coupon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.dao.entity.Coupon;
import com.tinysquare.dao.mapper.CouponMapper;

@Component
public class CouponService {

	@Autowired
	private CouponMapper couponMapper;

	public Coupon getByPrimaryKey(Long id) {
		return this.couponMapper.selectByPrimaryKey(id);
	}

}
