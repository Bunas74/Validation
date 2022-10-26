package by.epam.validation.controller.command.impl;

import by.epam.validation.bean.User;
import by.epam.validation.controller.command.Command;
import by.epam.validation.service.ClientService;
import by.epam.validation.service.exception.ServiceException;
import by.epam.validation.service.factory.ServiceFactory;

public class Register implements Command {

	@Override
	public String execute(String request) {

		String login = null;
		String password = null;
		String nickName = null;
		String email = null;
		String phoneNumber = null;
		String response = null;

		String[] requestArray = request.split(" ");
		login = requestArray[1];
		password = requestArray[2];
		nickName = requestArray[3];
		email = requestArray[4];
		phoneNumber = requestArray[5];

		User user = new User(login, password, nickName, email, phoneNumber);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getCLientService();

		try {
			if (clientService.registration(user)) {
				response = "Congratulations. You have successfully registered.";
			}
		} catch (ServiceException e) {
			// write log
			response = "Error duiring registration procedure";
		}
		return response;
	}
}
