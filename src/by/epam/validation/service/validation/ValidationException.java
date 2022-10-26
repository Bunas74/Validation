package by.epam.validation.service.validation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import by.epam.validation.service.exception.ServiceException;

public class ValidationException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Exception e) {
		super(e);
	}

	public ValidationException(String message, Exception e) {
		super(message, e);
	}

	public ValidationException(String message, Map<NameField, ErrorValidation> errors) {

		System.out.println(message);

		Set<NameField> keySet = errors.keySet();

		for (Iterator<NameField> it = keySet.iterator(); it.hasNext();) {

			NameField key = it.next();

			System.out.println(errors.get(key));
		}
	}
}
