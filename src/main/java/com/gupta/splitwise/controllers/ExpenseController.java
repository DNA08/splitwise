package com.gupta.splitwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gupta.splitwise.service.ExpenseService;

@Controller
public class ExpenseController {
	
	private ExpenseService expenseService;

	@Autowired
	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}

	public void addGroupExpense(Long userIdAddingPayment, Long groupId, double amount, String description) {
		this.expenseService.addGroupExpense(userIdAddingPayment,groupId,amount,description);
		
	}
	
	
}
