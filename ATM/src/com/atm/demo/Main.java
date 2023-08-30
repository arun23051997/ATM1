package com.atm.demo;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

//
//Decompiled by Procyon v0.5.36
//



import java.util.Scanner;

public class Main
{


 public static void main(final String[] args) throws SQLException {

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
             CreateAccount.createAccount1();
             break;
         }
         case 2: {
             AlreadyHaveAccount.alreadyHaveAccount();

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