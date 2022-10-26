package by.epam.validation.dao;

import by.epam.validation.bean.User;
import by.epam.validation.dao.exception.DAOException;

public interface UserDAO {

	public boolean signIn(String login, String password) throws DAOException;

	public boolean registration(User user) throws DAOException;
}
