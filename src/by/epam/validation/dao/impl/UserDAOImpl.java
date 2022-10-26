package by.epam.validation.dao.impl;

import by.epam.validation.bean.User;
import by.epam.validation.bean.exception.BeanException;
import by.epam.validation.bean.factory.BeanFactory;
import by.epam.validation.bean.impl.UserBeanImpl;
import by.epam.validation.dao.UserDAO;
import by.epam.validation.dao.exception.DAOException;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean signIn(String login, String password) throws DAOException {

		boolean checkSingIn = false;

		try {

			BeanFactory beanObjectFactory = BeanFactory.getInstance();
			UserBeanImpl userBeanImpl = beanObjectFactory.getUserBeanImpl();

			checkSingIn = userBeanImpl.userChecker(login, password);

		} catch (BeanException e) {
			throw new DAOException(e);
		}
		return checkSingIn;
	}

	@Override
	public boolean registration(User user) throws DAOException {

		boolean checkRegistration = false;

		try {

			BeanFactory beanObjectFactory = BeanFactory.getInstance();
			UserBeanImpl userBeanImpl = beanObjectFactory.getUserBeanImpl();

			checkRegistration = userBeanImpl.userWriter(user);

		} catch (BeanException e) {
			throw new DAOException(e);
		}
		return checkRegistration;

	}
}
