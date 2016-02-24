package com.tinysquare.api.favorite.command.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.favorite.command.IFavoriteCommand;
import com.tinysquare.api.favorite.service.FavoriteService;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.Favorite;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DateTools;

@Service
public class FavoriteCommand implements IFavoriteCommand {

	private final static Lock LOCK_FAVORITE_SHOP = new ReentrantLock();

	@Autowired
	private FavoriteService favoriteService;

	@Override
	public ResponseVo addShop(String token, Long shopId) {
		try {
			LOCK_FAVORITE_SHOP.lock();
			UserVo userVo = UserLocal.get();
			if (this.favoriteService.isFavorite(userVo.getObjId(), shopId)) {
				return ResponseVo.error(Error.ERROR_FAVORITED);
			}
			Favorite favorite = new Favorite();
			favorite.setUserId(userVo.getObjId());
			favorite.setShopId(shopId);
			favorite.setStatus(Constants.Status.NORMAL);
			favorite.setEntrydate(DateTools.now());
			this.favoriteService.save(favorite);
		} finally {
			LOCK_FAVORITE_SHOP.unlock();
		}
		return ResponseVo.success();
	}

}
