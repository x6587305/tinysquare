package com.tinysquare.api.message.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.message.command.IMessageCommand;
import com.tinysquare.api.message.service.MessageService;
import com.tinysquare.api.message.vo.MessageVo;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.threadlocal.UserLocal;

@Service
public class MessageCommand implements IMessageCommand {

	@Autowired
	private MessageService messageService;

	@Override
	public ResponseVo list(String token, PageVo pageVo) {
		UserVo userVo = UserLocal.get();
		List<MessageVo> messageVoList = this.messageService.selectVoByUserId(userVo.getObjId(), pageVo);
		Integer totalCount = this.messageService.countByUserId(userVo.getObjId());
		pageVo.setTotalCount(totalCount);
		pageVo.setResult(messageVoList);
		return ResponseVo.success(pageVo);
	}

}
