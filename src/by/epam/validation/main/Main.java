package by.epam.validation.main;

import by.epam.validation.controller.Controller;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();

		String a = "sign_in user@gmail.com 111111";
		System.out.println(controller.executeTask(a));

		System.out.println();

		String b = "sign_in 111111 user@gmail.com ";
		System.out.println(controller.executeTask(b));

		System.out.println();

		String c = "registration user149@gmail.com 444444 maximus16 user149@gmail.com +375(29)347-23-69";
		System.out.println(controller.executeTask(c));

		System.out.println();

		String d = "registration 444444 user149@gmail.com user149@gmail.com +375(29)347-23-69 maximus16";
		System.out.println(controller.executeTask(d));

		System.out.println();

		String f = "registration user678@gmail.com 555555 karl56 user678@gmail.com +375(44)364-27-60";
		System.out.println(controller.executeTask(f));

	}
}
