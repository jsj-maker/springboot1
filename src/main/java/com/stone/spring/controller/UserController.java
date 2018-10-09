package com.stone.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.spring.service.UserService;
import com.stone.spring.entities.User;
import com.stone.spring.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping("/getUserByUserId/{userId}")
	public @ResponseBody List<User> getUserByUserId(@PathVariable("userId") Long userId) {
		List<User> result = this.userService.findUserByUserId(userId);
		return result;
	}

	@RequestMapping("/getUserByUsername/{username}")
	public @ResponseBody List<User> getUserByUsername(@PathVariable("username") String username) {
		List<User> result = this.userService.getUserByUsername(username);
		return result;
	}

	@RequestMapping("/saveUser/{userName}")
	public @ResponseBody boolean saveUser(@PathVariable("userName") String userName) {

		User user = new User();
		user.setUsername(userName);
		user.setUserpwd("89578");
		userService.saveUser(user);
		return true;
	}

}
