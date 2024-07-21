package com.gupta.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter @Builder
@Table(name = "users")
public class User extends BaseModel {
	
	public User() {
		super();
	}


	public User(String name, String number, String hashPassword) {
		super();
		this.name = name;
		this.number = number;
		this.hashPassword = hashPassword;
	}


	private String name;
	private String number;
	private String hashPassword;
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", number=" + number + "]";
	}
	

}
