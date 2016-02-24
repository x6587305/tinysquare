package com.tinysquare.api.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.tinysquare.dao.entity.User;
import com.tinysquare.dao.entity.UserExample;
import com.tinysquare.dao.mapper.UserMapper;
import com.tinysquare.tools.DataTools;

@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 保存用户
	 * 
	 * @param entity
	 * @return
	 */
	public User save(User entity) {
		if (DataTools.isNull(entity)) {
			return null;
		}
		if (this.isRepeat(entity)) {
			return null;
		}
		if (entity.getId() == null) {
			this.userMapper.insertSelective(entity);
		} else {
			this.userMapper.updateByPrimaryKeySelective(entity);
		}
		return entity;
	}

	/**
	 * 判断用户是否重复
	 * 
	 * @param entity
	 * @return
	 */
	public boolean isRepeat(User entity) {
		User repeatUser = this.findByAccount(entity.getAccount());
		if (DataTools.isNull(repeatUser)) {
			return true;
		} else {
			if (entity.getId() != null && entity.getId().equals(repeatUser.getId())) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 根据账号查询用户信息
	 * 
	 * @param account
	 * @return
	 */
	public User findByAccount(String account) {
		UserExample example = new UserExample();
		example.or().andAccountEqualTo(account);
		List<User> list = userMapper.selectByExample(example);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

}
