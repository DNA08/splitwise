package com.gupta.splitwise.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gupta.splitwise.controllers.ExpenseController;
import com.gupta.splitwise.models.User;

@Component
public class AddExpenseInGroupCommand implements Command {
	
	private ExpenseController expenseController;
	
	@Autowired
	public AddExpenseInGroupCommand(ExpenseController expenseController) {
		super();
		this.expenseController = expenseController;
	}

	@Override
	public boolean canExecute(String input) {
		if(input.contains(Constants.EXPENSE) && input.contains(Constants.EQUAL_DESC)) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(String input) {
//		List<Long>owedByUsers = new ArrayList<>();
//		this.findOwedByUserIds(input,owedByUsers);
		String[] str = input.split(" ");
		Long userIdAddingPayment = Long.parseLong(str[0]);
		Long groupId = Long.parseLong(str[2]);
		double amount = Double.parseDouble(str[4]);
		String description = str[7]+" "+str[8];
		this.expenseController.addGroupExpense(userIdAddingPayment,groupId,amount,description);
		
	}

//	private void findOwedByUserIds(String input, List<Long> owedByUsers) {
//		String[] str = input.split(" ");
//		for(String s : str) {
//			while(s.equals(""))
//		}
//				
//	}

}
