package com.tinysquare.api.shop.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinysquare.api.shop.command.IShopCommand;
import com.tinysquare.api.shop.service.ShopImgService;
import com.tinysquare.api.shop.service.ShopService;
import com.tinysquare.api.shop.vo.ShopImgVo;
import com.tinysquare.api.shop.vo.ShopVo;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.Shop;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;
import com.tinysquare.tools.RegexTools;

@Service
public class ShopCommand implements IShopCommand {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopImgService shopImgService;

	@Override
	public ResponseVo detail(Long id) {
		ShopVo shopVo = this.shopService.getVoByPrimaryKey(id);
		if (shopVo == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		List<ShopImgVo> shopImgVoList = this.shopImgService.selectVoByShopId(id);
		shopVo.setImgs(shopImgVoList);
		shopVo.setUserId(null);
		return ResponseVo.success(shopVo);
	}

	@Override
	@Transactional
	public ResponseVo update(String token, String avator, String name, String tel, String brief, String address, String[] imgs) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (!DataTools.isEmpty(avator)) {
			avator = avator.trim();
			if (avator.length() > 200) {
				return ResponseVo.error(Error.ERROR_IMG_PATTERN);
			}
			shop.setAvator(avator);
		}
		if (!DataTools.isEmpty(name)) {
			name = name.trim();
			if (name.length() > 50) {
				return ResponseVo.error(Error.ERROR_SHOP_NAME_LENGTH);
			}
			shop.setName(name);
		}
		if (!DataTools.isEmpty(tel)) {
			if (!RegexTools.isMobile(tel)) {
				return ResponseVo.error(Error.ERROR_SHOP_TEL_PATTERN);
			}
			shop.setTel(tel);
		}
		if (!DataTools.isEmpty(brief)) {
			brief = brief.trim();
			if (brief.length() > 200) {
				return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_LENGTH);
			}
			shop.setBrief(brief);
		}
		if (!DataTools.isEmpty(address)) {
			address = address.trim();
			if (address.length() > 200) {
				return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_LENGTH);
			}
			shop.setAddress(address);
		}
		this.shopService.updateByPrimaryKey(shop);
		this.shopImgService.save(shop.getId(), imgs, DateTools.now());
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updateName(String token, String name) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(name)) {
			return ResponseVo.error(Error.ERROR_SHOP_NAME_EMPTY);
		}
		name = name.trim();
		if (name.length() > 50) {
			return ResponseVo.error(Error.ERROR_SHOP_NAME_LENGTH);
		}
		shop.setName(name);
		this.shopService.updateByPrimaryKey(shop);
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updateTel(String token, String tel) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(tel)) {
			return ResponseVo.error(Error.ERROR_SHOP_TEL_EMPTY);
		}
		if (!RegexTools.isMobile(tel)) {
			return ResponseVo.error(Error.ERROR_SHOP_TEL_PATTERN);
		}
		shop.setTel(tel);
		this.shopService.updateByPrimaryKey(shop);
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updateBrief(String token, String brief) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(brief)) {
			return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_EMPTY);
		}
		brief = brief.trim();
		if (brief.length() > 200) {
			return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_LENGTH);
		}
		shop.setBrief(brief);
		this.shopService.updateByPrimaryKey(shop);
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updateAddress(String token, String address) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(address)) {
			return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_EMPTY);
		}
		address = address.trim();
		if (address.length() > 200) {
			return ResponseVo.error(Error.ERROR_SHOP_ADDRESS_LENGTH);
		}
		shop.setAddress(address);
		this.shopService.updateByPrimaryKey(shop);
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updateAvator(String token, String avator) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(avator)) {
			return ResponseVo.error(Error.ERROR_SHOP_AVATAR_EMPTY);
		}
		avator = avator.trim();
		if (avator.length() > 200) {
			return ResponseVo.error(Error.ERROR_IMG_PATTERN);
		}
		shop.setAvator(avator.trim());
		this.shopService.updateByPrimaryKey(shop);
		return ResponseVo.success();
	}

	@Override
	@Transactional
	public ResponseVo updateImgs(String token, String[] imgs) {
		UserVo userVo = UserLocal.get();
		Shop shop = this.shopService.getByUserId(userVo.getObjId());
		if (shop == null) {
			return ResponseVo.error(Error.ERROR_SHOP_NOT_EXISTS);
		}
		if (DataTools.isEmpty(imgs)) {
			return ResponseVo.error(Error.ERROR_SHOP_IMGS_EMPTY);
		}
		this.shopImgService.save(shop.getId(), imgs, DateTools.now());
		return ResponseVo.success();
	}

}
