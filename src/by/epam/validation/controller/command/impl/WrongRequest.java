package by.epam.validation.controller.command.impl;

import by.epam.validation.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		
		String wrongRequest = "You must either register or login.";
		
		return wrongRequest;
	}
}
