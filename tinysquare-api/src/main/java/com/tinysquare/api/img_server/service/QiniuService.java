package com.tinysquare.api.img_server.service;

import org.springframework.stereotype.Component;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

@Component
public class QiniuService {

	private final static String ACCESS_KEY = "NPdYIfVvIQWh7ho2HFfT5-ryX3OSlu2pyClr7w__";

	private final static String SECRET_KEY = "4uJRrPMYfrDKapQM2sKKsZlYNsuVQiajjQ0zWhv2";

	private final static String BUCKET_NAME = "tinysquare";

	public Auth getAuth() {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		return auth;
	}

	public String getUploadToken() {
		Auth auth = getAuth();
		if (auth != null) {
			return auth.uploadToken(BUCKET_NAME);
		}
		return "";
	}

	public String getUploadToken(String key) {
		Auth auth = getAuth();
		if (auth != null) {
			// <bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
			// 如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
			// 第三个参数是token的过期时间
			// return auth.uploadToken(BUCKET_NAME, key, 3600, new
			// StringMap().put("insertOnly", 1));
			return auth.uploadToken(BUCKET_NAME, key, 3600, new StringMap());
		}
		return "";
	}

	public static void main(String[] args) {
		 QiniuService qs = new QiniuService();
		 System.out.println(qs.getUploadToken());
	}

}
