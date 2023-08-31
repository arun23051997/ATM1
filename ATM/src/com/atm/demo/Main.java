package com.atm.demo;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {

		boolean exitFlag = false;
		Scanner Userinput = new Scanner(System.in);

		while (!exitFlag) {
			System.out.println("1.Create Account");
			System.out.println("2.Already have Account");
			System.out.println("3. Exit");
			System.out.print("Choose Option : ");

			int UserSelectAccountType = Userinput.nextInt();
			switch (UserSelectAccountType) {
			case 1: {
				CreateAccount creatAccountObject = new CreateAccount();
				creatAccountObject.createAccount1();

				break;
			}
			case 2: {
				AlreadyHaveAccount alreadyHaveAccountObject = new AlreadyHaveAccount();
				alreadyHaveAccountObject.alreadyHaveAccount();

				break;
			}
			case 3: {
				exitFlag = true;
				System.out.println("Thank you for using our ATM. Goodbye!");
				System.exit(0);

				break;
			}
			default: {
				System.out.println("Please click correct choice!");
				break;
			}
			}
		}
	}
}