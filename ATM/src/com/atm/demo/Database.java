package com.atm.demo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Database 
 extends FormFilling {
	
    static String Name;
    static int Age;
    static String Gender;
    static String MobileNumber;
    static String Adhar;
    static String Email;
    static String AccountNumber;
    static String Pass;
    static Double Amount;
	static Double balance;
	static Scanner Scanner=new Scanner(System.in);


    public Database() {

    }

   
    public Database(String name,  int age,  String gender,  String mobileNumber, String adhar,  String email,  String accountNumber,  String pass, double amount) {
        
        Database.Name = name;
        Database.Age = age;
        Database.Gender = gender;
        Database.MobileNumber = mobileNumber;
        Database.Adhar = adhar;
        Database.Email = email;
        Database.AccountNumber = accountNumber;
        Database.Pass = pass;
        Database.Amount = amount;

    }




   




	public static Connection database() {
    	Database db=new Database();
         String url = "jdbc:mysql://localhost:3306/ATM";
         String username = "root";
         String password = "Ch@ngep0nd@123";
        Connection c=null;



        try {
             Connection con = DriverManager.getConnection(url, username, password);

            c=con;



       
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return c;

    }

    public static  void insert(Connection con) throws SQLException {
    String qry = "";
    qry = "insert into Form (Bank,Name,Age,Gender,MobileNumber,Adhar,Email,AccountNumber,Pass,Amount) values(?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement st = con.prepareStatement(qry);
    st.setString(1, Database.Bank);
    st.setString(2, Database.Name);
    st.setInt(3, Database.Age);
    st.setString(4, Database.Gender);
    st.setString(5, Database.MobileNumber);
    st.setString(6, Database.Adhar);
    st.setString(7, Database.Email);
    st.setString(8, Database.AccountNumber);
    st.setString(9, Database.Pass);
    st.setDouble(10, Database.Amount);
    st.executeUpdate();
    System.out.println("Account created success");
}
    
    
    public static List<String> check(Connection con) throws SQLException {
    
        List<String> getNameBank = new ArrayList<>();


    	System.out.println("Account Number: " + AlreadyHaveAccount.accountnumber1);
    	
		String qry="SELECT * FROM Form WHERE AccountNumber ="+AlreadyHaveAccount.accountnumber1;
	              Statement st =con.createStatement();

	            ResultSet rs = st.executeQuery(qry);

	          
	            rs.next();
	            
	                String name = rs.getString("Name");
	                String bank = rs.getString("Bank");

	                getNameBank.add(name);
	                getNameBank.add(bank);
	            

	            return getNameBank;
	        
    }
    
    
    
    static void  performWithdrawal(Connection con) throws SQLException {
    	AlreadyHaveAccount AlreadyHaveAccount=new AlreadyHaveAccount();
    	String qry="SELECT * FROM Form WHERE AccountNumber ="+AlreadyHaveAccount.accountnumber1;
    	Statement st =con.createStatement();

    	ResultSet rs = st.executeQuery(qry);

    	rs.next();
    	Double  name=    rs.getDouble("Amount");

    	if(name >0 && AlreadyHaveAccount.withdrawamount<name) {
    		  balance=(name-AlreadyHaveAccount.withdrawamount);
    	}
    	else {
    		System.out.println("Insufficiant Balance!!!!");
    		}
    	System.out.println("with draw amount--------" + AlreadyHaveAccount.withdrawamount);
    	System.out.println("balance" + name);
    	System.out.println("balance" + balance);

    	qry="UPDATE Form SET Amount ="+Database.balance + "WHERE AccountNumber ="+AlreadyHaveAccount.accountnumber1;

    	   PreparedStatement st1=con.prepareStatement(qry);
    	 st1.executeUpdate(qry);

    	System.out.println("Your withdraw amout : " + AlreadyHaveAccount.withdrawamount + "\n"
    	+"Your balance amount : "+Database.balance);
    	System.out.println("wihtdraw sucess!");
    }

   
    
    
    static void performDeposit(Connection con) throws SQLException {
    	System.out.println("deposite");
    	System.out.println("Which account deposit : ");
    	String accountnumber2=Scanner.next();
    	String qry="SELECT * FROM Form WHERE AccountNumber ="+accountnumber2;
    	Statement st =con.createStatement();
    	  ResultSet rs = st.executeQuery(qry);
    	  rs.next();
    	 Double name=    rs.getDouble("Amount");
    	 Double name1=name+AlreadyHaveAccount.deposit;

    	 qry="UPDATE Form SET Amount ="+name1+ "WHERE AccountNumber="+ accountnumber2;
    		PreparedStatement st1 = con.prepareStatement(qry);
    		  st1.executeUpdate(qry);
    			 System.out.println("Deposite Success!");	
    }
    
    
    
    static void checkBalance(Connection con) throws SQLException {
    	System.out.println("Checkbalance");
   	 String qry="SELECT * FROM Form WHERE AccountNumber ="+AlreadyHaveAccount.accountnumber1;
   	  Statement st =con.createStatement();
   	  ResultSet rs = st.executeQuery(qry);
   	  rs.next();
   	 Double name=    rs.getDouble("Amount");
   	 System.out.println("Your balance now : "+name);
    }

}