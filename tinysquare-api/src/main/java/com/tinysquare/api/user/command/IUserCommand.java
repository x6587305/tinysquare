package com.tinysquare.api.user.command;

import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.commons.vo.ResponseVo;

public interface IUserCommand {

	/**
	 * 普通用户注册
	 * 
	 * @param account
	 * @param password
	 * @param email
	 * @return
	 */
	public ResponseVo register(String account, String password, String email);

	/**
	 * 登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public ResponseVo login(String account, String password);

	/**
	 * 重置密码
	 * 
	 * @param account
	 * @param email
	 * @param newPassword
	 * @return
	 */
	public ResponseVo resetPassword(String account, String email, String newPassword);

	/**
	 * 修改密码
	 * 
	 * @param token
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public ResponseVo updatePassword(String token, String oldPassword, String newPassword);

	/**
	 * 我的
	 * 
	 * @param token
	 * @return
	 */
	public ResponseVo mine(String token);

	/**
	 * 根据token获取用户基本信息
	 * 
	 * @param token
	 * @return
	 */
	public UserVo getByToken(String token);

}
