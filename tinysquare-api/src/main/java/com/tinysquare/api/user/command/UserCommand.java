package com.tinysquare.api.user.command;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinysquare.api.user.service.UserService;
import com.tinysquare.dao.entity.User;

@Service
public class UserCommand {

	@Autowired
	private UserService userService;

	public void save() {
		User entity = new User();
		entity.setAccount("aaa");
		entity.setAvatar("aa");
		entity.setCategory(null);
		entity.setEmail("aa");
		entity.setEntrydate(new Date());
		entity.setImei("");
		entity.setMobile("18051094205");
		entity.setPassword("dfgsdafs");
		entity.setPlatform(null);
		entity.setStatus(null);
		entity.setTel("");
		entity.setVersion("1.0");
		this.userService.save(entity);
	}

}
