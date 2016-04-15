package com.tinysquare.api.user.vo;

import com.tinysquare.api.vip_card.vo.VipCardVo;

public class UserNormalVo extends UserVo {

	private static final long serialVersionUID = 1L;
	
	private VipCardVo vipCard;
	
	public UserNormalVo(Long objId, String account, String token, String tel, String mobile, String email, Byte category, VipCardVo vipCard) {
		super(objId, account, token, tel, mobile, email, category);
		this.vipCard = vipCard;
	}

	public VipCardVo getVipCard() {
		return vipCard;
	}

	public void setVipCard(VipCardVo vipCard) {
		this.vipCard = vipCard;
	}
	
	

}
