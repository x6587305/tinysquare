package com.tinysquare.api.favorite.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.commons.constants.Constants;
import com.tinysquare.dao.entity.Favorite;
import com.tinysquare.dao.entity.FavoriteExample;
import com.tinysquare.dao.mapper.FavoriteMapper;

@Component
public class FavoriteService {

	@Autowired
	private FavoriteMapper favoriteMapper;

	public boolean isFavorite(Long userId, Long shopId) {
		FavoriteExample example = new FavoriteExample();
		example.or().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andStatusEqualTo(Constants.Status.NORMAL);
		return this.favoriteMapper.countByExample(example) > 0;
	}

	public Favorite save(Favorite favorite) {
		if (favorite.getId() == null) {
			this.favoriteMapper.insertSelective(favorite);
		} else {
			this.favoriteMapper.updateByPrimaryKeySelective(favorite);
		}
		return favorite;
	}

	public List<Favorite> selectByUserIdAndShopIdList(Long userId, List<Long> shopIdList) {
		FavoriteExample example = new FavoriteExample();
		example.or().andUserIdEqualTo(userId).andShopIdIn(shopIdList).andStatusEqualTo(Constants.Status.NORMAL);
		example.setDistinct(true);
		return this.favoriteMapper.selectByExample(example);
	}

	public Set<Long> selectShopIdByUserIdAndShopIdList(Long userId, List<Long> shopIdList) {
		Set<Long> set = new HashSet<>();
		List<Favorite> list = this.selectByUserIdAndShopIdList(userId, shopIdList);
		list.forEach((favorite) -> set.add(favorite.getShopId()));
		return set;
	}

}
