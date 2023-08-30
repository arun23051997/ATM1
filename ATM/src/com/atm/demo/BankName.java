package com.atm.demo;

import java.sql.SQLException;
import java.util.Scanner;

public class BankName {

	public void bankName() throws SQLException {
		System.out.println("1. Indian Bank");
		System.out.println("2. State Bank");
		System.out.println("3. Indian Overseas Bank");
		System.out.println("Which bank you want ? : ");
		Scanner Userinput = new Scanner(System.in);
		String UserSelectBankName = Userinput.nextLine();
		FormFilling bank2 = new FormFilling();
		bank2.formFilling();

	}
}