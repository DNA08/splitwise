package com.gupta.splitwise.service;

import org.springframework.stereotype.Service;

import com.gupta.splitwise.models.ExpensePayingUser;
import com.gupta.splitwise.repositories.ExpensePayingUserRepository;

@Service
public class ExpensePayingUserService {

	private ExpensePayingUserRepository expPayingUserRepo;
	
	
	public ExpensePayingUserService(ExpensePayingUserRepository expPayingUserRepo) {
		super();
		this.expPayingUserRepo = expPayingUserRepo;
	}


	public void saveExpensePayingUser(ExpensePayingUser expu) {
		
		this.expPayingUserRepo.save(expu);
	}

}
