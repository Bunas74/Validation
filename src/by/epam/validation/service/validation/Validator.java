package by.epam.validation.service.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private ValidationException validationException;

	private Validator(Builder builder) {

		if (builder.getErrors() != null && !builder.getErrors().isEmpty()) {

			validationException = new ValidationException("Error: ", builder.getErrors());
		}
	}

	public ValidationException getValidationException() {
		return validationException;
	}

	public static class Builder implements ObjBuilder<Validator> {

		private Map<NameField, ErrorValidation> errors = new HashMap<>();

		public Map<NameField, ErrorValidation> getErrors() {
			return errors;
		}

		private static final String patternLogin = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
		private static final String patternPassword = "[\\d]+";
		private static final String patternNickName = "([a-z]+)([\\d]+)";
		private static final String patternEmail = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
		private static final String patternPhoneNumber = "[\\+\\d\\s\\(\\)\\-]+";

		private static final Pattern pLogin = Pattern.compile(patternLogin);
		private static final Pattern pPassword = Pattern.compile(patternPassword);
		private static final Pattern pNickName = Pattern.compile(patternNickName);
		private static final Pattern pEmail = Pattern.compile(patternEmail);
		private static final Pattern pPhoneNumber = Pattern.compile(patternPhoneNumber);

		public Builder validLogin(String login) {

			if (login == null) {

				errors.put(NameField.LOGIN, ErrorValidation.EMPTY_LOGIN);

			} else {

				Matcher m = pLogin.matcher(login);

				if (!m.matches()) {
					errors.put(NameField.LOGIN, ErrorValidation.INCORRECT_LOGIN);
				}
			}
			return this;
		}

		public Builder validPassword(String password) {

			if (password == null) {

				errors.put(NameField.PASSWORD, ErrorValidation.EMPTY_PASSWORD);

			} else {

				Matcher m = pPassword.matcher(password);

				if (!m.matches()) {

					errors.put(NameField.PASSWORD, ErrorValidation.INCORRECT_PASSWORD);
				}
			}
			return this;
		}

		public Builder validNickName(String nickName) {

			if (nickName == null) {

				errors.put(NameField.NICKNAME, ErrorValidation.EMPTY_NICKNAME);

			} else {

				Matcher m = pNickName.matcher(nickName);

				if (!m.matches()) {

					errors.put(NameField.NICKNAME, ErrorValidation.INCORRECT_NICKNAME);
				}
			}
			return this;
		}

		public Builder validEmail(String email) {

			if (email == null) {

				errors.put(NameField.EMAIL, ErrorValidation.EMPTY_EMAIL);

			} else {

				Matcher m = pEmail.matcher(email);

				if (!m.matches()) {

					errors.put(NameField.EMAIL, ErrorValidation.INCORRECT_EMAIL);
				}
			}
			return this;
		}

		public Builder validPhoneNumber(String phoneNumber) {

			if (phoneNumber == null) {

				errors.put(NameField.PHONE_NUMBER, ErrorValidation.EMPTY_PHONE_NUMBER);

			} else {

				Matcher m = pPhoneNumber.matcher(phoneNumber);

				if (!m.matches()) {

					errors.put(NameField.PHONE_NUMBER, ErrorValidation.INCORRECT_PHONE_NUMBER);
				}
			}
			return this;
		}

		public Validator build() {
			return new Validator(this);
		}
	}
}
