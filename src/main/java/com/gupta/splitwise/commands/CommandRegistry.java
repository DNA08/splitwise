package com.gupta.splitwise.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandRegistry {
	
	

	private List<Command> commands = new ArrayList<>();
	
	public boolean registerCommand(Command command) {
		if(commands.contains(command)) {
			return false;
		}
		commands.add(command);
		return true;
	}
	
	public void unregisterCommand(Command command) {
		commands.remove(command);
	}
	
	public void execute(String input) {
		for(Command command : commands) {
			if(command.canExecute(input)) {
				command.execute(input);
				return;
			}
		}
	}
	
	

}
