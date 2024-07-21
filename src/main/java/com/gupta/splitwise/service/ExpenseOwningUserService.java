package com.gupta.splitwise.service;

import org.springframework.stereotype.Service;

import com.gupta.splitwise.models.ExpenseOwningUser;
import com.gupta.splitwise.repositories.ExpenseOwningUserRepository;

@Service
public class ExpenseOwningUserService {
	
	private ExpenseOwningUserRepository expenseOwningUserRepo;

	public ExpenseOwningUserService(ExpenseOwningUserRepository expenseOwningUserRepo) {
		super();
		this.expenseOwningUserRepo = expenseOwningUserRepo;
	}

	public void saveUser(ExpenseOwningUser expenseOwningUser) {
		this.expenseOwningUserRepo.save(expenseOwningUser);
		
	}
	

}
