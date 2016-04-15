package com.tinysquare.api.user.vo;

import com.tinysquare.api.shop.vo.ShopVo;

public class UserShopVo extends UserVo {
	
	private static final long serialVersionUID = 1L;
	
	private ShopVo shop;
	
	public UserShopVo(Long objId, String account, String token, String tel, String mobile, String email, Byte category, ShopVo shop) {
		super(objId, account, token, tel, mobile, email, category);
		this.shop = shop;
	}

	public ShopVo getShop() {
		return shop;
	}

	public void setShop(ShopVo shop) {
		this.shop = shop;
	}

}
