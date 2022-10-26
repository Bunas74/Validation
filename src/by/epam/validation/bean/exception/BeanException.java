package by.epam.validation.bean.exception;

public class BeanException extends Exception {

	private static final long serialVersionUID = 1L;

	public BeanException() {
		super();
	}

	public BeanException(String message) {
		super(message);
		System.out.println(message);
	}

	public BeanException(Exception e) {
		super(e);
	}

	public BeanException(String message, Exception e) {
		super(message, e);
	}
}
