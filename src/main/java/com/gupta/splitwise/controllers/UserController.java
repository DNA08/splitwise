package com.gupta.splitwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gupta.splitwise.daos.RegisterUserRequestDao;
import com.gupta.splitwise.daos.RegisterUserResDto;
import com.gupta.splitwise.models.User;
import com.gupta.splitwise.service.UserService;

@Controller
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public RegisterUserResDto registerUser(RegisterUserRequestDao req) {
		User user = this.userService.addUser(req.getUserName(),req.getPassword(),req.getPhoneNo());
		RegisterUserResDto response = new RegisterUserResDto();
		response.setUser(user);
		return response;
	}



}
