// Paarth Badola
// 20012789

public class AccountNew extends Account {
	String name;
	
	//constructor that constructs an account with the specified name, id and balance
	public AccountNew(String name1, int id1, double balance1) {
		name = name1;
		setId(id1);
		setBalance(balance1);
	}

	public double getMonthlyInterestRate() {
		double monthlyInterestRate = (getInterest()/100) / 12;
		return monthlyInterestRate;
	}

	public double getMonthlyInterest() {
		double monthlyInterest = getBalance() * getMonthlyInterestRate();
		return monthlyInterest;
	}
	
	//withdraws a specified amount from the account
	public void withdraw(double amount) {
		if (amount > getBalance())
			throw new ArithmeticException("Insufficient Funds");
		setBalance(getBalance() - amount);
	}

	//deposits a specified amount to the account
	public void deposit(double amount) {
		if (amount < 0)
			throw new ArithmeticException("Amount cannot be negative");
		setBalance(getBalance() + amount);
	}
	
	
	public static void main(String [] args) {
		Account acc1 = new Account(20012789, 4000);
		Account acc2 = new Account();
		AccountNew acc3 = new AccountNew("Paarth", 24, 1200.70);
		
		System.out.println(acc1.getId());
		System.out.println("***********");
		System.out.println(acc1.getDate());
		System.out.println("***********");
		System.out.println(acc2.getInterest());
		System.out.println("***********");
		acc2.setId(1);
		System.out.println("***********");
		acc2.setBalance(500);
		System.out.println("***********");
		System.out.println(acc1.getId());
		System.out.println("***********");
		//acc2.setInterest(-9);
		System.out.println("***********");
		acc3.withdraw(250);
		System.out.println(acc3.getBalance());
		System.out.println("***********");
		acc3.deposit(600);
		System.out.println(acc3.getBalance());
		System.out.println("***********");
		acc3.setInterest(5);
		System.out.println("***********");
		System.out.println(acc3.getMonthlyInterestRate());
		System.out.println("***********");
		System.out.println(acc3.getMonthlyInterest());
		
	}
}
