package by.epam.validation.dao.factory;

import by.epam.validation.dao.UserDAO;
import by.epam.validation.dao.impl.UserDAOImpl;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO sqlUserImpl = new UserDAOImpl();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}
}
