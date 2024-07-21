package com.gupta.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class ExpenseOwningUser extends BaseModel {
	
	@ManyToOne
	private Expense expense;
	
	@ManyToOne
	private User user;
	
	private Double amount;

	@Override
	public String toString() {
		return "ExpenseOwningUser [expense=" + expense + ", user=" + user + ", amount=" + amount + "]";
	}
	

}
