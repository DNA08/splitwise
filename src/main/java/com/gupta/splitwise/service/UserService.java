package com.gupta.splitwise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gupta.splitwise.models.User;
import com.gupta.splitwise.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public User addUser(String userName, String password, String phoneNo) {
		User user = User.builder().name(userName).hashPassword(password).number(phoneNo).build();
		User savedUser = this.userRepo.save(user);
		
		return savedUser;
	}

	public User findUserById(Long userIdToBeAdded) {
		return this.userRepo.findById(userIdToBeAdded).get();
	}

}
