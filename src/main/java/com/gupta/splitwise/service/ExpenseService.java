package com.gupta.splitwise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gupta.splitwise.models.Currency;
import com.gupta.splitwise.models.Expense;
import com.gupta.splitwise.models.ExpenseOwningUser;
import com.gupta.splitwise.models.ExpensePayingUser;
import com.gupta.splitwise.models.Group;
import com.gupta.splitwise.models.User;
import com.gupta.splitwise.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private ExpenseRepository expenseRepo;
	
	private GroupService groupService;
	
	private UserService userService;
	
	private ExpensePayingUserService exPayingUserService;
	
	private ExpenseOwningUserService expenseOwningUserService;
	
	

	public ExpenseService(ExpenseRepository expenseRepo, GroupService groupService, UserService userService,
			ExpensePayingUserService exPayingUserService, ExpenseOwningUserService expenseOwningUserService) {
		super();
		this.expenseRepo = expenseRepo;
		this.groupService = groupService;
		this.userService = userService;
		this.exPayingUserService = exPayingUserService;
		this.expenseOwningUserService = expenseOwningUserService;
	}

	public void addGroupExpense(Long userIdAddingPayment, Long groupId, double amount, String description) {
		Group group = this.groupService.findGroupById(groupId);
		User userAddingPayment = this.userService.findUserById(userIdAddingPayment);
		Currency cur = Currency.builder().name("Indian").symbol("INR").build();
		Expense exp = new Expense();
		exp.setAmount(amount);
		exp.setCreatedBy(userAddingPayment);
		exp.setDescription(description);
		exp.setCurrency(cur);
		
		Expense savedExpense = this.expenseRepo.save(exp);
		
		this.addExpensePayingUserObj(savedExpense,userAddingPayment);
		this.addExpenseOwningUserObj(savedExpense,group);
		
	}

	private void addExpenseOwningUserObj(Expense savedExpense, Group group) {
		double amountPerUser = savedExpense.getAmount() / group.getParticipants().size();
		for(User user : group.getParticipants()) {
			ExpenseOwningUser expenseOwningUser = new ExpenseOwningUser();
			expenseOwningUser.setAmount(amountPerUser);
			expenseOwningUser.setUser(user);
			expenseOwningUser.setExpense(savedExpense);
			this.expenseOwningUserService.saveUser(expenseOwningUser);
		}
	}

	private void addExpensePayingUserObj(Expense savedExpense, User userAddingPayment) {
		ExpensePayingUser expu = new ExpensePayingUser();
		expu.setExpense(savedExpense);
		expu.setAmount(savedExpense.getAmount());
		expu.setUser(userAddingPayment);
		this.exPayingUserService.saveExpensePayingUser(expu);
		
	}

	

}
