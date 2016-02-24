package com.tinysquare.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tinysquare.api.user.command.UserCommand;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserCommand userCommand;

	@RequestMapping("/register")
	public void register() {
		this.userCommand.save();
	}

}
