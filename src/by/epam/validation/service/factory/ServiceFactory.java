package by.epam.validation.service.factory;

import by.epam.validation.service.ClientService;
import by.epam.validation.service.impl.ClientServiceImpl;

public final class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private final ClientService clientService = new ClientServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ClientService getCLientService() {
		return clientService;
	}

}
