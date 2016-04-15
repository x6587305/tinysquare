package com.tinysquare.api.img_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.img_server.command.IImgServerCommand;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.tools.DataTools;

@RestController
@RequestMapping("/imgServer")
public class ImgServerController {

	@Autowired
	private IImgServerCommand imgServerCommand;

	/**
	 * 获取token
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	public ResponseVo getToken(@RequestParam(required = false) String key) {
		ResponseVo reponseVo = null;
		if (DataTools.isEmpty(key)) {
			reponseVo = imgServerCommand.getUploadToken();
		} else {
			reponseVo = imgServerCommand.getUploadToken(key);
		}
		return reponseVo;
	}

}
