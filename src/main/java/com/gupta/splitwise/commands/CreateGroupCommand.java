package com.gupta.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gupta.splitwise.controllers.GroupController;

@Component
public class CreateGroupCommand implements Command {

	private GroupController groupController;
	
	@Autowired
	public CreateGroupCommand(GroupController groupController) {
		super();
		this.groupController = groupController;
	}

	@Override
	public boolean canExecute(String input) {
		if(input.contains(Constants.ADD_GROUP)) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(String input) {
		String[] str = input.split(" ");
		String adminId = str[0];
		String groupName = str[2];
		this.groupController.createGroup(adminId, groupName);
	}

}
