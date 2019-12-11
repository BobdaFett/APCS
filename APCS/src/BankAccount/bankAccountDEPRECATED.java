package BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * This application is EXTREMELY DEPRECATED.
 * Use the JavaFX version for more functionality and a nice user interface.
 * 
 * @author lvas
 *
 */

public class bankAccountDEPRECATED {

	public double money;
	public int overdraft=35;
	public String name;
	Scanner scan = new Scanner(System.in);
	
	public bankAccountDEPRECATED() {
		money = 0;
		nameAccount();
	}
	
	public void nameAccount() {
		String affirm;
		int x = 0;
		
		System.out.print("Please enter the name of the created account: ");
		name = scan.nextLine();
			
		System.out.print("Did you want to name this account \"" + name + "\"? ");
		affirm = scan.nextLine();
		
		if(affirm.toLowerCase().equals("yes")) {
			System.out.print("Your new account is now named \"" + name + ".\n\n");
			deposit();
		} else if (affirm.toLowerCase().equals("no")) {
			System.out.println();
			nameAccount();
		} else {
			System.out.println("\nSorry, I didn't understand that. Try again.\n\n");
			nameAccount();
		}
        
		
		name:
		while(x == 0) {
			switch (affirm.toLowerCase()) {
	        case "yes":
	            System.out.print("Your new account is now named \"" + name + ".\n\n");
	            deposit();
	            break name;
	        case "no":
	        	System.out.println("Enter a new name for your account: ");
	        	name = scan.nextLine();
	        	continue name;
	        default:
	        	System.out.println("That didn't work. Try again.");
	        	nameAccount();
	        	break;
	        }
		}
	}
	
	public void withdraw() {
		double setAmount;
		String a;
		System.out.print("Please enter the amount of money you would like to withdraw: ");
		setAmount = scan.nextDouble();
		money-=setAmount;
		if (money < 0) {
			System.out.print("Taking out this amount of money will apply an overdraft fee to your account.\nAre you sure you want to do this?");
			a = scan.nextLine();
			if (a.toLowerCase().equals("yes")) {
				System.out.printf("You have successfully withdrawn $%.2f. \n",setAmount);
				System.out.printf("You now have $%.2f left in your account " + name + ".",money);
				menu();
			} else if (a.toLowerCase().equals("no")) {
				System.out.print("\n\n");
				money+=setAmount;
				withdraw();
			} else {
				System.out.print("That didn't work. Try again.");
			}
		} else {
			System.out.printf("You have successfully withdrawn $%.2f. \n",setAmount);
			System.out.printf("You now have $%.2f left in your account " + name + ".",money);
			menu();
		}
	}
	
	public void deposit() {
		double setAmount;
		System.out.print("Please enter the amount of money you would like to deposit: ");
		try {
			setAmount = scan.nextDouble();
			money+=setAmount;
			System.out.printf("You have successfully deposited $%.2f. \n",setAmount);
			System.out.printf("You now have $%.2f in your account " + name + ".\n\n",money);
		} catch (InputMismatchException e) {
			System.out.println("ERROR - Try again. \n\n");
			deposit();
		}

		menu();
	}
	
	public void getBalance() {
		if (money < 0) {
			int days;
			System.out.print("You have an overdraft. Please enter how many days it has been: ");
			days = 5 * scan.nextInt();
			money-=overdraft-days;
			System.out.printf("You have $%.2f in your account " + name + ".",money);
		} else {
			System.out.printf("You have $%.2f in your account " + name + ".\n",money);
			menu();
		}
	}
	
	public void menu() {
		String option;
		@SuppressWarnings("resource")
		Scanner scan2 = new Scanner(System.in);
		System.out.print("Please enter what you would like to do, or type help for a list of functions: ");
		option = scan2.nextLine();
		
		switch(option.toLowerCase()) {
		case "help":
			System.out.print("The options are: deposit, withdraw, rename, balance\n\n");
			menu();
			break;
		case "deposit":
			deposit();
			break;
		case "withdraw":
			withdraw();
			break;
		case "rename":
			nameAccount();
			break;
		case "balance":
			getBalance();
			break;
		default:
			System.out.print("Sorry, that didn't work. Try again.\n\n\n");
			menu();
			break;
		}
		
	}
	
}
