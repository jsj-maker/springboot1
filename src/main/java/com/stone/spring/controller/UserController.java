package com.stone.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.spring.service.UserService;
import com.stone.spring.entities.User;

@Controller
public class UserController {

//	@Autowired
//	public UserService userService;

	@RequestMapping("/getUserByUserId/{userId}")
	public @ResponseBody String getUserByUserId(@PathVariable("userId") String userId) {
		
		return userId;
	}

	

}
