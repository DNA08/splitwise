package com.gupta.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gupta.splitwise.controllers.GroupController;

@Component
public class AddUserToGroupCommand implements Command {

	@Autowired
	public AddUserToGroupCommand(GroupController groupController) {
		super();
		this.groupController = groupController;
	}

	private GroupController groupController;
	
	@Override
	public boolean canExecute(String input) {
		if(input.contains(Constants.ADD_USER_TO_GROUP)) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(String input) {
		String[] str = input.split(" ");
		Long adminId = Long.parseLong(str[0]);
		Long groupId = Long.parseLong(str[2]);
		Long userIdToBeAdded = Long.parseLong(str[3]);
		this.groupController.addMember(adminId, groupId, userIdToBeAdded);

	}

}
