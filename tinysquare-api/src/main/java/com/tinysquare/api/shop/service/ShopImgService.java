package com.tinysquare.api.shop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.api.shop.vo.ShopImgVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.dao.entity.ShopImg;
import com.tinysquare.dao.entity.ShopImgExample;
import com.tinysquare.dao.mapper.ShopImgMapper;
import com.tinysquare.tools.DataTools;

@Component
public class ShopImgService {

	@Autowired
	private ShopImgMapper shopImgMapper;

	public List<ShopImg> selectByShopId(Long shopId) {
		ShopImgExample example = new ShopImgExample();
		example.or().andShopIdEqualTo(shopId);
		return this.shopImgMapper.selectByExample(example);
	}

	public List<ShopImgVo> selectVoByShopId(Long shopId) {
		List<ShopImgVo> shopImgVoList = new ArrayList<>();
		List<ShopImg> shopImgList = this.selectByShopId(shopId);
		shopImgList.forEach((shopImg) -> shopImgVoList.add(new ShopImgVo(shopImg.getId(), shopImg.getUrl())));
		return shopImgVoList;
	}

	public ShopImg save(ShopImg shopImg) {
		if (shopImg.getId() == null) {
			this.shopImgMapper.insertSelective(shopImg);
		} else {
			this.shopImgMapper.updateByPrimaryKeySelective(shopImg);
		}
		return shopImg;
	}

	public void save(Long shopId, String[] imgs, Date entrydate) {
		this.deleteByShopId(shopId);
		if (!DataTools.isEmpty(imgs)) {
			List<ShopImg> shopImgList = new ArrayList<>();
			List<String> imgUrlList = Arrays.asList(imgs);
			imgUrlList.stream().filter(img -> !DataTools.isEmpty(img)).forEach((img) -> {
				ShopImg shopImg = new ShopImg();
				shopImg.setShopId(shopId);
				shopImg.setUrl(img.trim());
				shopImg.setStatus(Constants.Status.NORMAL);
				shopImg.setEntrydate(entrydate);
				shopImgList.add(shopImg);
			});
			if (!CollectionUtils.isEmpty(shopImgList)) {
				this.save(shopImgList);
			}
		}
	}

	public List<ShopImg> save(List<ShopImg> shopImgList) {
		shopImgList.forEach((shopImg) -> this.save(shopImg));
		return shopImgList;
	}

	public Integer deleteStatusByShopId(Long shopId) {
		ShopImgExample example = new ShopImgExample();
		example.or().andShopIdEqualTo(shopId);
		ShopImg shopImg = new ShopImg();
		shopImg.setStatus(Constants.Status.DELETE);
		return this.shopImgMapper.updateByExampleSelective(shopImg, example);
	}

	public Integer deleteByShopId(Long shopId) {
		ShopImgExample example = new ShopImgExample();
		example.or().andShopIdEqualTo(shopId);
		return this.shopImgMapper.deleteByExample(example);
	}

	public Integer deleteByShopIdAndStatus(Long shopId, Byte status) {
		ShopImgExample example = new ShopImgExample();
		example.or().andShopIdEqualTo(shopId).andStatusEqualTo(status);
		return this.shopImgMapper.deleteByExample(example);
	}

}
