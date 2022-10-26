package by.epam.validation.controller.command.impl;

import by.epam.validation.controller.command.Command;
import by.epam.validation.service.ClientService;
import by.epam.validation.service.exception.ServiceException;
import by.epam.validation.service.factory.ServiceFactory;

public class SingIn implements Command {

	@Override
	public String execute(String request) {

		String login = null;
		String password = null;
		String response = null;

		String[] requestArray = request.split(" ");
		login = requestArray[1];
		password = requestArray[2];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getCLientService();

		try {
			if (clientService.singIn(login, password)) {
				response = "Welcome";
			}
		} catch (ServiceException e) {
			// write log
			response = "Error duiring login procedure";
		}
		return response;
	}
}
