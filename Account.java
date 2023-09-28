//************************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, and get a String representation
// of the account.
//************************************************************

import java.util.Random;

public class Account
{
	private double balance;
	private String name;
	private int acctNum;
	private static Random rnd = new Random();
	private final static int MAX = 999999;
	private final static int MIN = 111111;
	private static int numAccounts = 0;
	
	//------------------------------------------------------------------
	//Constructor -- sets initial balance to zero, sets initial owner
	//               to "Unknown", and randomly generates account number
	//------------------------------------------------------------------
	public Account()
	{
		balance = 0.0;
		name = "Unknown";
		acctNum = rnd.nextInt(MAX - MIN + 1) + MIN;
		numAccounts++;
	}
	
	public Account(String owner)
	{
		// initializes the owner as specified
		// sets the initial balance to 0 
		// and randomly generates the account number.
		name = owner;
		balance = 0;
		acctNum = rnd.nextInt(MAX - MIN + 1) + MIN;
		numAccounts++;
	}
	
	public Account(double initBal, String owner)
	{
		// initializes the balance and owner as specified; 
		// randomly generates the account number.
		balance = initBal;
		name = owner;
		acctNum = rnd.nextInt(MAX - MIN + 1) + MIN;
		numAccounts++;
	}

	//-------------------------------------------------------------
	//Constructor -- initializes balance, owner, and account number
	//-------------------------------------------------------------
	public Account(double initBal, String owner, int number)
	{
		balance = initBal;
		name = owner;
		acctNum = number;
		numAccounts++;
	}

	//-------------------------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	//-------------------------------------------------------------
	public void withdraw(double amount)
	{
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("Insufficient funds");
	}
	
	public void withdraw(double amount, double fee)
	{
		double total = amount + fee;
		withdraw(total);
	}

	//-------------------------------------------------
	// Adds deposit amount to balance.
	//-------------------------------------------------
	public void deposit(double amount)
	{
		balance += amount;
	}

	//-------------------------------------------------
	// Returns balance.
	//-------------------------------------------------
	public double getBalance()
	{
		return balance;
	}

	//-------------------------------------------------
	// Returns a string containing the name, account number, and balance.
	//-------------------------------------------------
	public String toString()
	{
		return "Name:" + name +
				"\nAccount Number: " + acctNum +
				"\nBalance: " + balance;
	}
	
	public static int getNumAccounts()
	{
		return numAccounts;
	}
	
	public void close()
	{
		name += "-CLOSED";
		balance = 0;
		numAccounts--;		
	}
	
	public static Account consolidate(Account acct1, Account acct2)
	{
		Account acct3 = null;
		
		if(acct1.name.equalsIgnoreCase(acct2.name)
				&& acct1.acctNum != acct2.acctNum)
		{
			acct3 = new Account(acct1.name);
			acct3.balance = acct1.balance + acct2.balance;
			acct1.close();
			acct2.close();
		}
		else
		{
			System.out.println("Error, unable to consolidate accounts");
		}
		
		return acct3;
	}
	
	public void transfer(Account acct, double amount)
	{
		if(balance >= amount)
		{
			this.balance -= amount;
			acct.balance += amount;
		}
		else
		{
			System.out.println("Error.  Insufficient funds.");
		}
	}
	
	public static void transfer(Account acct1, Account acct2, double amount)
	{
		acct1.transfer(acct2, amount);
	}
}
