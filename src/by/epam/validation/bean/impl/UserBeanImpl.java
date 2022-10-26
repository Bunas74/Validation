package by.epam.validation.bean.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import by.epam.validation.bean.User;
import by.epam.validation.bean.UserBean;
import by.epam.validation.bean.exception.BeanException;

public class UserBeanImpl implements UserBean {

	private final String sourcePath = "src/resources/resources.txt";

	@Override
	public boolean userChecker(String login, String password) throws BeanException {

		boolean check;
		User userCheck;

		userCheck = userCreator(login);
		check = password.equals(userCheck.getPassword());

		return check;
	}

	@Override
	public User userCreator(String login) throws BeanException {

		User userCheck = null;

		try (FileReader reader = new FileReader(sourcePath); Scanner sc = new Scanner(reader)) {

			while (sc.hasNextLine()) {

				String line = sc.nextLine();

				if (line.contains(login)) {

					String[] arr = line.split(" ");
					userCheck = new User(arr[0], arr[1], arr[2], arr[3], arr[4]);
				}
			}

		} catch (IOException e) {

			throw new BeanException("File not found.");
		}
		return userCheck;
	}

	@Override
	public boolean userWriter(User user) throws BeanException {

		boolean isWrite = false;
		User userCheck;

		String login = user.getLogin();

		userCheck = userCreator(login);

		if (userCheck != null) {

			throw new BeanException("A user this login already exists.");

		} else {

			try (FileWriter fw = new FileWriter(sourcePath, true)) {

				String userRegistration = user.getLogin() + " " + user.getPassword() + " " + user.getNickName() + " "
						+ user.getEmail() + " " + user.getPhoneNumber() + "\n";

				fw.write(userRegistration);

			} catch (IOException e) {

				throw new BeanException("Error writing to file.");
			}
			isWrite = true;
		}
		return isWrite;
	}

}
