package com.atm.demo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class AlreadyHaveAccount {
	static String accountnumber1;
	static String pass1;
	static double withdrawamount;
	 static double deposit;
	 static boolean exitFlag = false;

	//public static  Double withdrawamount;
	public static void alreadyHaveAccount() throws SQLException {

		Scanner Scanner=new Scanner(System.in);
		
		System.out.println("Enter your AccountNumber : ");
		accountnumber1=Scanner.next();
		 System.out.println("Enter Your Password : ");
		pass1=Scanner.next();


		  List<String> name=   Database.check(Database.database());
		
		  String names = name.get(0); // Assuming name is at index 0
		  String bank = name.get(1); // Assuming bank is at index 1

		  System.out.println("Hello " + names + " Welcome to " + bank);






//		  System.out.println("Hello "+name+" Welcome to "+bank);
		 while (!exitFlag) {
		System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Statement");
        System.out.println("5. Main");
        System.out.print("Enter choice: ");
        int choice = Scanner.nextInt();

        switch (choice) {
            case 1:

                Database.checkBalance(Database.database());
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                	deposit = Scanner.nextDouble();
				Database.performDeposit(Database.database());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                withdrawamount= Scanner.nextDouble();


    			Database.performWithdrawal(Database.database());
                break;
            case 4:
            	 System.out.print("Statement");
                break;
            case 5:

                Main.main(new String[0]);

                break;
            default:
            	System.out.println("Please click correct choice!");
            	 //System.exit(0);
        }


	}
	}
}