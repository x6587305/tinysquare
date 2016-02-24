package com.tinysquare.api.user.command.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tinysquare.api.user.command.IUserCommand;
import com.tinysquare.api.user.service.UserService;
import com.tinysquare.api.user.vo.UserTokenVo;
import com.tinysquare.api.user.vo.UserVo;
import com.tinysquare.api.vip_card.service.VipCardService;
import com.tinysquare.api.vip_card.vo.VipCardVo;
import com.tinysquare.commons.common.Token;
import com.tinysquare.commons.constants.Constants;
import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.exception.BusException;
import com.tinysquare.commons.vo.RequestVo;
import com.tinysquare.commons.vo.ResponseVo;
import com.tinysquare.dao.entity.User;
import com.tinysquare.threadlocal.RequestLocal;
import com.tinysquare.threadlocal.UserLocal;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.DateTools;
import com.tinysquare.tools.RegexTools;
import com.tinysquare.tools.SecretTools;

@Service
public class UserCommand implements IUserCommand {

	private final static Lock LOCK_REGISTER = new ReentrantLock();

	@Autowired
	private UserService userService;
	@Autowired
	private VipCardService vipCardService;

	@Override
	public ResponseVo register(String account, String password, String email) {
		try {
			LOCK_REGISTER.lock();
			User user = new User();
			user.setAccount(account);
			user.setPassword(password);
			user.setTel("");
			user.setEmail(email);
			user.setAvatar("");
			user.setCategory(Constants.User.USER_CATEGORY_NORMAL);
			user.setImei("");
			user.setMobile("");
			user.setStatus(Constants.Status.NORMAL);
			RequestVo requestVo = RequestLocal.get();
			user.setPlatform(requestVo.getPlatform());
			user.setVersion(Constants.App.VERSION);
			user.setEntrydate(DateTools.now());
			String error = this.userService.validate(user);
			if (!DataTools.isEmpty(error)) {
				return ResponseVo.error(error);
			}
			user.setPassword(SecretTools.md5(password));
			this.userService.save(user);
			user.setToken(Token.generate(user.getId(), user.getAccount(), user.getPassword()));
			this.userService.save(user);
			UserTokenVo userTokenVo = new UserTokenVo(user.getAccount(), user.getToken(), user.getTel(), user.getMobile(), user.getEmail(), user.getCategory());
			return ResponseVo.success(userTokenVo);
		} finally {
			LOCK_REGISTER.unlock();
		}
	}

	@Override
	public ResponseVo login(String account, String password) {
		if (DataTools.isEmpty(account)) {
			return ResponseVo.error(Error.ERROR_ACCOUNT_EMPTY);
		}
		if (DataTools.isEmpty(password)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_EMPTY);
		}
		User user = this.userService.getByAccount(account);
		if (user == null || Constants.Status.NORMAL != user.getStatus()) {
			return ResponseVo.error(Error.ERROR_ACCOUNT_NOT_EXISTS);
		}
		password = SecretTools.md5(password);
		if (password.equals(user.getPassword())) {
			user.setToken(Token.generate(user.getId(), user.getAccount(), user.getPassword()));
			this.userService.save(user);
			UserTokenVo userTokenVo = new UserTokenVo(user.getAccount(), user.getToken(), user.getTel(), user.getMobile(), user.getEmail(), user.getCategory());
			return ResponseVo.success(userTokenVo);
		} else {
			return ResponseVo.error(Error.ERROR_ACCOUNT_PASSWORD);
		}
	}

	@Override
	public ResponseVo resetPassword(String account, String email, String newPassword) {
		User user = this.userService.getByAccount(account);
		if (user == null) {
			throw new BusException(Error.ERROR_USER_NOT_EXISTS);
		}
		if (DataTools.isEmpty(email)) {
			return ResponseVo.error(Error.ERROR_EMAIL_EMPTY);
		}
		email = email.trim();
		if (!email.equals(user.getEmail())) {
			return ResponseVo.error(Error.ERROR_EMAIL_REGISTER);
		}
		if (DataTools.isEmpty(newPassword)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_NEW_EMPTY);
		}
		newPassword = newPassword.trim();
		if (!RegexTools.isWordAndNum(newPassword, 6, 20)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_PATTERN);
		}
		newPassword = SecretTools.md5(newPassword);
		if (newPassword.equals(user.getPassword())) {
			return ResponseVo.error(Error.ERROR_PASSWORD_SAME);
		}
		user.setPassword(newPassword);
		user.setToken(Token.generate(user.getId(), user.getAccount(), user.getPassword()));
		this.userService.save(user);
		return ResponseVo.success();
	}

	@Override
	public ResponseVo updatePassword(String token, String oldPassword, String newPassword) {
		UserVo userVo = UserLocal.get();
		User user = this.userService.getByPrimaryKey(userVo.getObjId());
		if (user == null) {
			throw new BusException(Error.ERROR_USER_NOT_EXISTS);
		}
		if (DataTools.isEmpty(oldPassword)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_OLD_EMPTY);
		}
		oldPassword = SecretTools.md5(oldPassword.trim());
		if (!oldPassword.equals(user.getPassword())) {
			return ResponseVo.error(Error.ERROR_PASSWORD_OLD);
		}
		if (DataTools.isEmpty(newPassword)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_NEW_EMPTY);
		}
		newPassword = newPassword.trim();
		if (!RegexTools.isWordAndNum(newPassword, 6, 20)) {
			return ResponseVo.error(Error.ERROR_PASSWORD_PATTERN);
		}
		newPassword = SecretTools.md5(newPassword);
		if (newPassword.equals(user.getPassword())) {
			return ResponseVo.error(Error.ERROR_PASSWORD_SAME);
		}
		user.setPassword(newPassword);
		user.setToken(Token.generate(user.getId(), user.getAccount(), user.getPassword()));
		this.userService.save(user);
		UserTokenVo userTokenVo = new UserTokenVo(user.getAccount(), user.getToken(), user.getTel(), user.getMobile(), user.getEmail(), user.getCategory());
		return ResponseVo.success(userTokenVo);
	}

	@Override
	public ResponseVo mine(String token) {
		UserVo userVo = UserLocal.get();
		if (userVo.getCategory() == Constants.User.USER_CATEGORY_NORMAL) {
			List<VipCardVo> vipCardList = this.vipCardService.selectVoByUserId(userVo.getObjId());
			if (!CollectionUtils.isEmpty(vipCardList)) {
				userVo.setVipCard(vipCardList.get(0));
			}
		}
		return ResponseVo.success(userVo);
	}

	@Override
	public UserVo getByToken(String token) {
		User user = this.userService.getByToken(token);
		if (user == null) {
			throw new BusException(Error.ERROR_USER_NOT_EXISTS);
		}
		UserVo userVo = new UserVo(user.getId(), user.getAccount(), user.getToken(), user.getTel(), user.getMobile(), user.getEmail(), user.getCategory());
		return userVo;
	}

}
