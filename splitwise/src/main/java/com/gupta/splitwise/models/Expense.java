package com.gupta.splitwise.models;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class Expense extends BaseModel {
	@ManyToOne
	private User createdBy;
	private Double amount;
	private String description;
	
//	List<User>participatingUsers;
		
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Currency currency;
	
	@Override
	public String toString() {
		return "Expense [createdBy=" + createdBy + ", amount=" + amount + ", description=" + description + ", currency="
				+ currency + "]";
	}
	

	
}
