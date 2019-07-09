package solution;

import java.util.ArrayList;
import java.util.List;

public class Account
{
	private static List<Account> accounts = new ArrayList<Account>();
	
	private String number;
	private double balance;
	
	public Account(String number, double balance)
	{
		setNumber(number);
		setBalance(balance);
		
		accounts.add(this);
	}
	
	public static Account find(String accountNumber)
	{
		for (Account account : accounts)
			if (account.getNumber().equals(accountNumber))
				return account;
		return null;
	}

	public String getNumber() { return number; }
	public double getBalance() { return balance; }

	public void setNumber(String number) { this.number = number; }
	public void setBalance(double balance) { this.balance = balance; }
	
	@Override
	public String toString()
	{
		return "    Account#: " + number + "\n    Balance:  " + balance;
	}
}
