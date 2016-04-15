package com.tinysquare.api.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.app.vo.UpdateVo;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.commons.vo.ShareVo;

@RestController
@RequestMapping("/app")
public class AppController {

	/**
	 * 验证是否更新
	 * 
	 * @return
	 */
	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST)
	public ResponseVo checkUpdate() {
		UpdateVo udateVo = new UpdateVo();
		udateVo.setAppStatus(Constants.App.APP_STATUS_NONE);
		udateVo.setGlobalAppPath("");
		udateVo.setUpdateContent("");
		udateVo.setVersions("");
		return ResponseVo.success(udateVo);
	}

	/**
	 * 分享
	 * 
	 * @return
	 */
	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public ResponseVo share() {
		ShareVo shareVo = new ShareVo("http://7xtczz.com1.z0.glb.clouddn.com/tinysquareicon108.png", "TinySquare", "TinySquare app", "http://tiny-square.com/");
		return ResponseVo.success(shareVo);
	}

}
