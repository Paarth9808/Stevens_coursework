// Paarth Badola
// 20012789

import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 9;
	
	private Date dateCreated;
	
	// constructor for default account
	public Account() {
		dateCreated = new java.util.Date();
		System.out.println("The default Account is created.");
	}
	
	// constructor for account with given values
	public Account(int id, double balance) {
		if (id<0 || balance<0)
			throw new ArithmeticException("id or balance cannot be negative");
		this.id = id;
		this.balance = balance;
		dateCreated = new java.util.Date();
		System.out.println("The Account is created.");
	}
	
	public int getId() {
		//System.out.println("The Id is: ");
		return id;
	}
	
	public void setId(int newId) {
		if (newId < 0)
			throw new ArithmeticException("Id cannot be negative");
		id = newId;
		System.out.println("New Id set successfully");
	}
	
	public double getBalance() {
		//System.out.println("The balance is: ");
		return balance;
	}
	
	public void setBalance(double amount) {
		if (amount < 0)
			throw new ArithmeticException("Amount cannot be negative");
		balance = amount;
		System.out.println("New Balance set successfully");
	}
	
	public double getInterest() {
		//System.out.println("The Interest rate is: ");
		return annualInterestRate;
	}
	
	public void setInterest(double interest) {
		if (interest < 0)
			throw new ArithmeticException("Interest rate cannot be negative");
		annualInterestRate = interest;
		System.out.println("New Interest Rate set successfully");
	}
	
	// public accessor method for dateCreated
	public String getDate() {
		System.out.println("The Date Account created is: ");
		return dateCreated.toString();
	}
}


