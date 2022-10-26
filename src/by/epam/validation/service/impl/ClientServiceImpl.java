package by.epam.validation.service.impl;

import by.epam.validation.bean.User;
import by.epam.validation.dao.UserDAO;
import by.epam.validation.dao.exception.DAOException;
import by.epam.validation.dao.factory.DAOFactory;
import by.epam.validation.service.ClientService;
import by.epam.validation.service.exception.ServiceException;
import by.epam.validation.service.validation.ValidationException;
import by.epam.validation.service.validation.Validator;

public class ClientServiceImpl implements ClientService {

	@Override
	public boolean singIn(String login, String password) throws ServiceException {

		boolean checkUserSingIn;

		Validator.Builder validBuild = new Validator.Builder();
		Validator validator = validBuild.validLogin(login).validPassword(password).build();

		if (validator.getValidationException() != null) {
			throw new ValidationException();
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();

			checkUserSingIn = userDAO.signIn(login, password);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return checkUserSingIn;
	}

	@Override
	public boolean registration(User user) throws ServiceException {

		boolean checkUserRegistration;

		String login = user.getLogin();
		String password = user.getPassword();
		String nickName = user.getNickName();
		String email = user.getEmail();
		String phoneNumber = user.getPhoneNumber();

		Validator.Builder validBuild = new Validator.Builder();
		Validator validator = validBuild.validLogin(login).validPassword(password).validNickName(nickName)
				.validEmail(email).validPhoneNumber(phoneNumber).build();

		if (validator.getValidationException() != null) {
			throw new ValidationException();
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();

			checkUserRegistration = userDAO.registration(user);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return checkUserRegistration;
	}

	@Override
	public boolean singOut(String login) throws ServiceException {
		return false;
	}
}
