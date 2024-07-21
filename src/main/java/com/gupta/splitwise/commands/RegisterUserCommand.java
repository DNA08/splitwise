package com.gupta.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gupta.splitwise.controllers.UserController;
import com.gupta.splitwise.daos.RegisterUserRequestDao;

@Component
public class RegisterUserCommand implements Command {

	private UserController userController;
	
	@Autowired
	public RegisterUserCommand(UserController userController) {
		super();
		this.userController = userController;
	}

	@Override
	public boolean canExecute(String input) {
		if(input.contains(Constants.REGISTER_COMMAND)) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(String input) {
		
		String[] inputs = input.split(" ");
		RegisterUserRequestDao req = RegisterUserRequestDao.builder().userName(inputs[1]).password(inputs[3]).phoneNo(inputs[2]).build();
		this.userController.registerUser(req);
	}

}
