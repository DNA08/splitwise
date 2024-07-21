package com.gupta.splitwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gupta.splitwise.commands.AddExpenseInGroupCommand;
import com.gupta.splitwise.commands.AddUserToGroupCommand;
import com.gupta.splitwise.commands.CommandRegistry;
import com.gupta.splitwise.commands.CreateGroupCommand;
import com.gupta.splitwise.commands.RegisterUserCommand;
import com.gupta.splitwise.commands.UpdateProfileCommand;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	@Autowired
	private CommandRegistry commandRegistry;
	
	@Autowired
	private RegisterUserCommand registerUserCommand;
	
	@Autowired
	private UpdateProfileCommand updateProfileCommand;
	
	@Autowired
	private CreateGroupCommand createGroupCommand; 
	
	@Autowired
	private AddUserToGroupCommand addUserToGroupCommand;
	
	@Autowired
	private AddExpenseInGroupCommand addExpenseInGroupCommand;
	
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandRegistry.registerCommand(registerUserCommand);
		commandRegistry.registerCommand(updateProfileCommand);
		commandRegistry.registerCommand(addUserToGroupCommand);
		commandRegistry.registerCommand(createGroupCommand);
		commandRegistry.registerCommand(addExpenseInGroupCommand);
//		commandRegistry.registerCommand(addExpenseInDefaultGroup);
		
		String input = "Register Sarthak 8443XXXXXX password";
		String input1 = "Register xyzuvw 3774XXXXXX poossworrrrd";
		String input2 = "Register Naimish 80XXXXXXX Stoploss";
		String input3 = "Register Aman 727XXXXXXXX ChuchuRTV";
		
		commandRegistry.execute(input);
		commandRegistry.execute(input1);
		commandRegistry.execute(input2);
		commandRegistry.execute(input3);
		
		String input4 = "1 AddGroup Roommates";
		
		commandRegistry.execute(input4);
		
		String input5 = "1 AddMember 1 2";
		
		commandRegistry.execute(input5);
		
		String input6 = "1 AddMember 1 3";
		String input7 = "1 AddMember 1 4";
		commandRegistry.execute(input6);
		commandRegistry.execute(input7);
		
		String input8 = "1 Expense 1 1 1000 Equal Desc Wifi Bill";
		commandRegistry.execute(input8);
		
	}

}
