package com.tinysquare.api.vip_card.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.api.vip_card.vo.VipCardVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.dao.entity.VipCard;
import com.tinysquare.dao.entity.VipCardExample;
import com.tinysquare.dao.entityex.VipCardItem;
import com.tinysquare.dao.mapper.VipCardMapper;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;

@Component
public class VipCardService {

	@Autowired
	private VipCardMapper vipCardMapper;

	public VipCard getByPrimaryKey(Long id) {
		return this.vipCardMapper.selectByPrimaryKey(id);
	}

	public VipCard save(VipCard vipCard) {
		if (vipCard.getId() == null) {
			this.vipCardMapper.insertSelective(vipCard);
		} else {
			this.vipCardMapper.updateByPrimaryKeySelective(vipCard);
		}
		return vipCard;
	}

	public List<VipCardItem> selectByUserId(Long userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return this.vipCardMapper.selectByUserId(params);
	}

	public List<VipCardVo> selectVoByUserId(Long userId) {
		List<VipCardVo> vipCardVoList = new ArrayList<>();
		List<VipCardItem> vipCardList = this.selectByUserId(userId);
		vipCardList.forEach((vipCard) -> vipCardVoList.add(new VipCardVo(vipCard.getId(), null, vipCard.getShopId(), vipCard.getCardNum(), vipCard.getImg(),
				vipCard.getBrief(), vipCard.getPoints(), vipCard.getUserTimes(), vipCard.getCategory(), vipCard.getIsDefault(), vipCard.getStatus(),
				DateTools.format(vipCard.getEntrydate()), !DataTools.isEmpty(vipCard.getImg()) ? null : vipCard.getShopName())));
		return vipCardVoList;
	}

	public Integer setDefaultByUserId(Long userId, Byte isDefault) {
		VipCardExample example = new VipCardExample();
		example.or().andUserIdEqualTo(userId).andStatusEqualTo(Constants.Status.NORMAL);
		VipCard vipCard = new VipCard();
		vipCard.setIsDefault(isDefault);
		return this.vipCardMapper.updateByExampleSelective(vipCard, example);
	}

}
