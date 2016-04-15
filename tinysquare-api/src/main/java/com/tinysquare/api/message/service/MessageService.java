package com.tinysquare.api.message.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysquare.api.message.vo.MessageVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.vo.PageVo;
import com.tinysquare.dao.entity.Message;
import com.tinysquare.dao.entity.MessageExample;
import com.tinysquare.dao.mapper.MessageMapper;
import com.tinysquare.tools.DateTools;

@Component
public class MessageService {

	@Autowired
	private MessageMapper messageMapper;

	public Message getByPrimaryKey(Long id) {
		return this.messageMapper.selectByPrimaryKey(id);
	}

	public MessageVo getVoByPrimaryKey(Long id) {
		Message message = this.getByPrimaryKey(id);
		if (message == null) {
			return null;
		}
		return new MessageVo(message.getId(), null, message.getTitle(), message.getSubject(), message.getAuthor(), message.getContent(), message.getIsRead(),
				DateTools.format(message.getEntrydate()));
	}

	public List<Message> selectByUserId(Long userId, PageVo pageVo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("pageBegin", pageVo.getPageBegin());
		params.put("pageSize", pageVo.getPageSize());
		return this.messageMapper.selectByUserId(params);
	}

	public List<MessageVo> selectVoByUserId(Long userId, PageVo pageVo) {
		List<MessageVo> messageVoList = new ArrayList<>();
		List<Message> messageList = this.selectByUserId(userId, pageVo);
		messageList.forEach((message) -> messageVoList.add(new MessageVo(message.getId(), null, message.getTitle(), message.getSubject(), message.getAuthor(),
				message.getContent(), message.getIsRead(), DateTools.format(message.getEntrydate()))));
		return messageVoList;
	}

	public Integer countByUserId(Long userId) {
		MessageExample example = new MessageExample();
		example.or().andUserIdEqualTo(userId).andStatusEqualTo(Constants.Status.NORMAL);
		return this.messageMapper.countByExample(example);
	}

	public Integer read(Long id, Long userId) {
		MessageExample example = new MessageExample();
		example.or().andUserIdEqualTo(userId).andIdEqualTo(id);
		Message messageUpdate = new Message();
		messageUpdate.setIsRead(Constants.Message.READ);
		return this.messageMapper.updateByExampleSelective(messageUpdate, example);
	}

}
