package com.gupta.splitwise.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter @Table(name = "groups")
public class Group extends BaseModel {
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> participants;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> admins;
	
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Expense> expenses;

	@Override
	public String toString() {
		return "Group [name=" + name + ", participants=" + participants + ", admins=" + admins + ", description="
				+ description + ", expenses=" + expenses + "]";
	}
	

}
