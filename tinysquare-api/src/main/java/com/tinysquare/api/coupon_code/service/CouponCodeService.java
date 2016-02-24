package com.tinysquare.api.coupon_code.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.dao.entity.CouponCode;
import com.tinysquare.dao.entity.CouponCodeExample;
import com.tinysquare.dao.mapper.CouponCodeMapper;
import com.tinysquare.tools.DateTools;

@Component
public class CouponCodeService {

	@Autowired
	private CouponCodeMapper couponCodeMapper;

	public CouponCode getByCode(String code) {
		CouponCodeExample example = new CouponCodeExample();
		example.or().andCodeEqualTo(code).andStatusEqualTo(Constants.Status.NORMAL);
		List<CouponCode> couponCodeList = this.couponCodeMapper.selectByExample(example);
		return CollectionUtils.isEmpty(couponCodeList) ? null : couponCodeList.get(0);
	}

	public Integer redeem(CouponCode couponCode) {
		if (couponCode != null) {
			couponCode.setRedeemTime(DateTools.now());
			couponCode.setStatus(Constants.Status.INVALID);
			return this.couponCodeMapper.updateByPrimaryKeySelective(couponCode);
		}
		return 0;
	}

}
