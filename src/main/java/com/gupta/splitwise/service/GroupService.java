package com.gupta.splitwise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gupta.splitwise.models.Group;
import com.gupta.splitwise.models.User;
import com.gupta.splitwise.repositories.GroupRepository;

@Service
public class GroupService {
	
	

	private GroupRepository groupRepo;
	private UserService userService;
	
	@Autowired
	public GroupService(GroupRepository groupRepo, UserService userService) {
		super();
		this.groupRepo = groupRepo;
		this.userService = userService;
	}
	public Group createGroup(String adminId, String groupName) {
		Group group = new Group();
		User admin = this.userService.findUserById(Long.parseLong(adminId));
		group.setAdmins(List.of(admin));
		group.setName(groupName);
		group.setParticipants(List.of(admin));
		Group savedGroup = this.groupRepo.save(group);
		return savedGroup;
		
	}
	public void addMember(Long adminId, Long groupId, Long userIdToBeAdded) {
		Group group = this.groupRepo.findById(groupId).get();
		User userToBeAdded = this.userService.findUserById(userIdToBeAdded);
		for(User admin : group.getAdmins()) {
			if(admin.getId().equals(adminId)) {
				group.getParticipants().add(userToBeAdded);
			}
		}
		this.groupRepo.save(group);
		
		
	}
	public Group findGroupById(Long groupId) {
		// TODO Auto-generated method stub
		return this.groupRepo.findById(groupId).get();
	}

}
