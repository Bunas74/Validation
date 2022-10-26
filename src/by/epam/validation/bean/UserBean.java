package by.epam.validation.bean;

import by.epam.validation.bean.exception.BeanException;

public interface UserBean {

	public boolean userChecker(String login, String password) throws BeanException;

	public User userCreator(String login) throws BeanException;

	public boolean userWriter(User user) throws BeanException;

}
