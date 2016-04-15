package com.tinysquare.api.img_server.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.img_server.command.IImgServerCommand;
import com.tinysquare.api.img_server.service.QiniuService;
import com.tinysquare.commons.vo.ResponseVo;

@Service
public class QiniuCommand implements IImgServerCommand {

	@Autowired
	private QiniuService qiniuService;

	@Override
	public ResponseVo getUploadToken() {
		String token = qiniuService.getUploadToken();
		return ResponseVo.success(token);
	}

	@Override
	public ResponseVo getUploadToken(String key) {
		String token = qiniuService.getUploadToken(key);
		return ResponseVo.success(token);
	}

}
