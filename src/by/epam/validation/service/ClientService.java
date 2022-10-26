package by.epam.validation.service;

import by.epam.validation.bean.User;
import by.epam.validation.service.exception.ServiceException;

public interface ClientService {

	public boolean singIn(String login, String password) throws ServiceException;

	public boolean registration(User user) throws ServiceException;

	public boolean singOut(String login) throws ServiceException;
}
