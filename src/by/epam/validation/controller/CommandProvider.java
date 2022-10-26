package by.epam.validation.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.validation.controller.command.Command;
import by.epam.validation.controller.command.CommandName;
import by.epam.validation.controller.command.impl.Register;
import by.epam.validation.controller.command.impl.SingIn;
import by.epam.validation.controller.command.impl.WrongRequest;

final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SingIn());
		repository.put(CommandName.REGISTRATION, new Register());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		// ...
	}

	public Command getCommand(String name) {

		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			// write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
