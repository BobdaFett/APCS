package BankAccount;

public class bankAccount {
	
	public String name = "";
	public double balance = 0;
	
	public bankAccount(String newName) {
		name = newName;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void rename(String newName) {
		name = newName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getName() {
		return name;
	}
	
}
