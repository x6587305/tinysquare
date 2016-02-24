package com.tinysquare.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysquare.api.user.command.IUserCommand;
import com.tinysquare.commons.vo.ResponseVo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserCommand userCommand;

	/**
	 * 普通用户注册
	 * 
	 * @param account
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseVo register(@RequestParam(required = true) String account, @RequestParam(required = true) String password,
			@RequestParam(required = true) String email) {
		ResponseVo reponseVo = userCommand.register(account, password, email);
		return reponseVo;
	}

	/**
	 * 登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseVo register(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		ResponseVo reponseVo = userCommand.login(account, password);
		return reponseVo;
	}

	/**
	 * 重置密码
	 * 
	 * @param token
	 * @param email
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ResponseVo resetPassword(@RequestParam(required = true) String account, @RequestParam(required = true) String email,
			@RequestParam(required = true) String newPassword) {
		ResponseVo reponseVo = userCommand.resetPassword(account, email, newPassword);
		return reponseVo;
	}

	/**
	 * 修改密码
	 * 
	 * @param token
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ResponseVo updatePassword(@RequestParam(required = true) String token, @RequestParam(required = true) String oldPassword,
			@RequestParam(required = true) String newPassword) {
		ResponseVo reponseVo = userCommand.updatePassword(token, oldPassword, newPassword);
		return reponseVo;
	}

	/**
	 * 我的
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/mine", method = RequestMethod.POST)
	public ResponseVo mine(@RequestParam(required = true) String token) {
		ResponseVo reponseVo = userCommand.mine(token);
		return reponseVo;
	}

}
