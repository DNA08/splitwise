package com.gupta.splitwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gupta.splitwise.service.GroupService;

@Controller
public class GroupController {
	
	private GroupService groupService;
	
	@Autowired
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}


	public void createGroup(String adminId, String groupName) {
		this.groupService.createGroup(adminId, groupName);
		
	}


	public void addMember(Long adminId, Long groupId, Long userIdToBeAdded) {
		this.groupService.addMember(adminId,groupId,userIdToBeAdded);
		
	}

}
