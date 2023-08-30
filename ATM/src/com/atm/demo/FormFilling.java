package com.atm.demo;

import java.util.Scanner;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FormFilling
{
   static String Bank;
    //LocalDateTime Time;

    
    
    public FormFilling(String UserSelectBankName) {
    //    this.Time = LocalDateTime.now();
        this.Bank = UserSelectBankName;
    }

    public FormFilling() {
		
	}

	public void formFilling() throws SQLException {
         Scanner scanner = new Scanner(System.in);
        System.out.println("Ener you name : ");
       String Name = scanner.next();
        System.out.println("Age : ");
         int Age = scanner.nextInt();
        System.out.println("Gender : ");
         String Gender = scanner.next();
        System.out.println("Mobile Number : ");
         String MobileNumber = scanner.next();
        System.out.println("Adhar : ");
       String Adhar = scanner.next();
        System.out.println("Email : ");
        String Email = scanner.next();
        System.out.println("Account Number : ");
         String AccountNumber = scanner.next();
        System.out.println("Pass : ");
        String Pass = scanner.next();
        System.out.println("Amount : ");
        double Amount = scanner.nextDouble();
        Object bank2;
		Database SendDatabase = new Database( Name, Age, Gender, MobileNumber, Adhar, Email, AccountNumber, Pass, Amount);
        SendDatabase.insert(Database.database());
        


    }

}