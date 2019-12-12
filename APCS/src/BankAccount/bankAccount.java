package BankAccount;

/**
 * 
 * This is the class that should allow me to save which account I'm working on and managing.
 * Eventually I will start creating extra functions in the base application that allow me to manage multiple at once.
 * 
 * @author Lucas Vas
 *
 */

public class BankAccount {
	
	public String name = "";
	public double balance = 0;
	
	public BankAccount(String newName) {
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
