package by.epam.validation.bean.factory;

import by.epam.validation.bean.impl.UserBeanImpl;

public final class BeanFactory {

	private static final BeanFactory instance = new BeanFactory();

	private final UserBeanImpl userBeanImpl = new UserBeanImpl();

	private BeanFactory() {
	}

	public static BeanFactory getInstance() {
		return instance;
	}

	public UserBeanImpl getUserBeanImpl() {
		return userBeanImpl;
	}

}
