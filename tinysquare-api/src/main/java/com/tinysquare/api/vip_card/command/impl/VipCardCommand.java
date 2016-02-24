package com.tinysquare.api.vip_card.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.api.vip_card.command.IVipCardCommand;
import com.tinysquare.api.vip_card.service.VipCardService;
import com.tinysquare.api.vip_card.vo.VipCardVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.VipCard;
import com.tinysquare.threadlocal.UserLocal;

@Service
public class VipCardCommand implements IVipCardCommand {

	@Autowired
	private VipCardService vipCardService;

	@Override
	public ResponseVo list(String token) {
		UserVo userVo = UserLocal.get();
		List<VipCardVo> messageVoList = this.vipCardService.selectVoByUserId(userVo.getObjId());
		return ResponseVo.success(messageVoList);
	}

	@Override
	public ResponseVo setDefault(String token, Long id) {
		UserVo userVo = UserLocal.get();
		VipCard vipCard = this.vipCardService.getByPrimaryKey(id);
		if (vipCard == null) {
			return ResponseVo.error(Error.ERROR_VIP_CARD_NOT_EXISTS);
		}
		this.vipCardService.setDefaultByUserId(userVo.getObjId(), Constants.Boolean.FALSE);
		vipCard.setIsDefault(Constants.Boolean.TRUE);
		this.vipCardService.save(vipCard);
		return ResponseVo.success();
	}

}
