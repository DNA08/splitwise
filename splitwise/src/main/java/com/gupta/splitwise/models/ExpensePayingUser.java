package com.gupta.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity
public class ExpensePayingUser extends BaseModel {
	
	@ManyToOne
	private Expense expense;
	
	@ManyToOne
	private User user;
	
	private Double amount;

	@Override
	public String toString() {
		return "ExpensePayingUser [expense=" + expense + ", user=" + user + ", amount=" + amount + "]";
	}

}
