package com.tinysquare.api.img_server.command;

import com.tinysquare.commons.vo.ResponseVo;

public interface IImgServerCommand {

	/**
	 * 获取token
	 * 
	 * @return
	 */
	public ResponseVo getUploadToken();

	/**
	 * 获取对应key的token
	 * 
	 * @param key
	 *            图片名称
	 * @return
	 */
	public ResponseVo getUploadToken(String key);

}
