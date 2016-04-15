package com.tinysquare.api.message.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.message.command.IMessageCommand;
import com.tinysquare.api.message.service.MessageService;
import com.tinysquare.api.message.vo.MessageVo;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.Message;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DateTools;

@Service
public class MessageCommand implements IMessageCommand {

	@Autowired
	private MessageService messageService;

	@Override
	public ResponseVo get(String token, Long id) {
		UserVo userVo = UserLocal.get();
		Message message = this.messageService.getByPrimaryKey(id);
		if (message == null || userVo == null || userVo.getObjId() == null || userVo.getObjId() != message.getUserId()) {
			return ResponseVo.success();
		}
		if (Constants.Message.UNREAD == message.getIsRead()) {
			messageService.read(id, userVo.getObjId());
		}
		return ResponseVo.success(new MessageVo(message.getId(), null, message.getTitle(), message.getSubject(), message.getAuthor(), message.getContent(),
				message.getIsRead(), DateTools.format(message.getEntrydate())));
	}

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
