package BankAccount;

import java.util.ArrayList;

public class ObjectTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		BankAccount acc1 = new BankAccount("My Bank Account");
		BankAccount acc2 = new BankAccount("My Second Bank Account");
		
		accounts.add(acc1); //index 0
		accounts.add(acc2); //index 1
		
		accounts.get(0); //this essentially turns the list into the object at that index - in this case, this is now the BankAccount acc1
		accounts.get(1); //this is BankAccount acc2
		
		accounts.get(0).getBalance(); //you can call methods with this as well
		
		System.out.println(accounts.get(0).getBalance());
		System.out.println(accounts.get(0).getName());
	}

}
