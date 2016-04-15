package com.tinysquare.api.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tinysquare.commons.constants.Error;
import com.tinysquare.commons.exception.BusException;
import com.tinysquare.dao.entity.User;
import com.tinysquare.dao.entity.UserExample;
import com.tinysquare.dao.mapper.UserMapper;
import com.tinysquare.tools.DataTools;
import com.tinysquare.tools.RegexTools;

@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 验证用户数据
	 * 
	 * @param user
	 * @return
	 * 
	 */
	public String validate(User user) {
		if (DataTools.isEmpty(user.getAccount())) {
			return Error.ERROR_ACCOUNT_EMPTY;
		}
		user.setAccount(user.getAccount().trim());
		if (!RegexTools.isMobile(user.getAccount())) {
			return Error.ERROR_ACCOUNT_PATTERN;
		}
		if (DataTools.isEmpty(user.getPassword())) {
			return Error.ERROR_PASSWORD_EMPTY;
		}
		user.setPassword(user.getPassword().trim());
		if (!RegexTools.isWordAndNum(user.getPassword(), 6, 20)) {
			return Error.ERROR_PASSWORD_PATTERN;
		}
		if (DataTools.isEmpty(user.getEmail())) {
			return Error.ERROR_EMAIL_EMPTY;
		}
		user.setEmail(user.getEmail().trim());
		if (!RegexTools.isEmail(user.getEmail())) {
			return Error.ERROR_EMAIL_PATTERN;
		}
		if (user.getEmail().length() > 100) {
			return Error.ERROR_EMAIL_PATTERN;
		}
		if (this.isRepeat(user)) {
			return Error.ERROR_ACCOUNT_REPEAT;
		}
		return null;
	}

	/**
	 * 保存用户
	 * 
	 * @param entity
	 * @return
	 */
	public User save(User user) {
		if (user.getId() == null) {
			this.userMapper.insertSelective(user);
		} else {
			this.userMapper.updateByPrimaryKeySelective(user);
		}
		return user;
	}

	/**
	 * 判断用户是否重复
	 * 
	 * @param entity
	 * @return
	 */
	public boolean isRepeat(User user) {
		User repeatUser = this.getByAccount(user.getAccount());
		if (repeatUser == null) {
			return false;
		} else {
			if (user.getId() != null && user.getId().equals(repeatUser.getId())) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 根据账号查询用户信息
	 * 
	 * @param account
	 * @return
	 */
	public User getByAccount(String account) {
		UserExample example = new UserExample();
		example.or().andAccountEqualTo(account);
		List<User> userList = this.userMapper.selectByExample(example);
		return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	public User getByPrimaryKey(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据token查询用户
	 * 
	 * @param token
	 * @return
	 */
	public User getByToken(String token) {
		if (DataTools.isEmpty(token)) {
			throw new BusException(Error.ERROR_TOKEN);
		}
		UserExample example = new UserExample();
		example.or().andTokenEqualTo(token);
		List<User> userList = this.userMapper.selectByExample(example);
		return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
	}

}
