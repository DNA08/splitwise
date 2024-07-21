package com.gupta.splitwise.daos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserRequestDao {
	private String userName;
	private String password;
	private String phoneNo;
	
}
