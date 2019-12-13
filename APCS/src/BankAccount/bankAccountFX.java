package BankAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * 
 * Working on changing the entire program to be able to create and manage multiple bank accounts,
 * while also being able to take those accounts and transfer money between them.
 * 
 * Takes a little more work than you would think.
 * 
 * Overall, most basic functionality is finished, and you are able to create and manage a single bank account.
 * 
 * @author BobdaFett
 */

@SuppressWarnings("exports")
public class bankAccountFX extends Application {
	
	static String tempName = "";
	static double tempBalance;
	static int editing;
	static Button b1;
	static Button b2;
	static Button b3;
	static Button b4;
	static Button b5;
	static Button renameButton;
	static Scene base;
	static Stage stage;
	static GridPane gp;
	static ArrayList<BankAccount> accounts;
	
	public void start(Stage s) throws Exception {
		stage = new Stage();
		
		accounts = new ArrayList<BankAccount>();
		
		b1 = new Button("_Create new bank account");
		b1.setOnAction(e -> {
			createAccount();
		});
		
		renameButton = new Button();
		renameButton.setOnAction(e -> {
			rename();
		});
		
		b2 = new Button("_Withdraw");
		b2.setOnAction(e -> {
			System.out.println(accounts.size());
			if(accounts.size() == 0) {
				errorWindow("NO BANK ACCOUNT", "Please return and click \"Create new Bank Account\" to continue.");
			} else {
				withdraw(); 
			}
		});
		
		b3 = new Button("_Deposit");
		b3.setOnAction(e -> {
			if(accounts.size() == 0) {
				errorWindow("NO BANK ACCOUNT", "Please return and click \"Create new Bank Account\" to continue.");
			} else {
				deposit(); 
			}
		});
		
		b4 = new Button("Show Balance");
		b4.setOnAction(e -> {
			if(accounts.size() == 0) {
				errorWindow("NO BANK ACCOUNT", "Please return and click \"Create new Bank Account\" to continue.");
			} else {
				showBalance(); 
			}
		});
		
		b5 = new Button("Choose Account");
		b5.setOnAction(e -> {
			chooseAccount();
		});
		
		gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		gp.add(b4, 1, 1);
		gp.add(b5, 0, 2);
		
		gp.setPadding(new Insets(15));
		gp.setVgap(10);
		gp.setHgap(10);
		
		base = new Scene(gp);
		
		stage.setScene(base);
		stage.show();
		
	}
	
	public static void createAccount() {
		
		TextInputDialog create = new TextInputDialog();
		create.setTitle("Create an Account");
		create.setHeaderText("Account Creation");
		create.setContentText("Enter the account name:");
		
		Optional<String> accName = create.showAndWait(); //waits until the user exits the dialog, and then queries the "ifPresent" method. if there's nothing there, it does nothing.
		accName.ifPresent(e -> {
			tempName = accName.get();
			BankAccount acc = new BankAccount(tempName);
			accounts.add(acc);
			renameButton.setText("Rename account " + tempName);
			gp.getChildren().remove(b1);
			gp.add(renameButton, 0, 0);
			stage.setScene(base);
		});
		
	}
	
	public static void rename() {
		
		TextInputDialog rename = new TextInputDialog();
		rename.setTitle("Rename Account");
		rename.setHeaderText("Rename your account " + tempName);
		rename.setContentText("Enter your new account name:");
		
		Optional<String> accName = rename.showAndWait();
		accName.ifPresent(e -> {
			tempName = accName.get();
			renameButton.setText("Rename account " + tempName);
			gp.getChildren().remove(renameButton);
			gp.add(renameButton, 0, 0);
			stage.setScene(base);
		});
		
	}
	
	public static void withdraw() {
	
		TextInputDialog withdraw = new TextInputDialog();
		withdraw.setTitle("Withdraw");
		withdraw.setHeaderText("Withdraw Money");
		withdraw.setContentText("Enter the amount to withdraw:");
		
		Optional<String> amount = withdraw.showAndWait();
		amount.ifPresent(e -> {
			try {
				double temp = Double.parseDouble(amount.get());
				
				if(temp < 0) {
					errorWindow("Function Mismatch", "Please use the deposit function for this.");
				} else if((tempBalance-temp) < 0) {
					Alert overdraft = new Alert(AlertType.CONFIRMATION);
					overdraft.setTitle("Overdraft Confirmation");
					overdraft.setContentText("Are you sure you want to take out this amount?\nIt will apply an overdraft fee of $35 to your account " + tempName);
					
					Optional<ButtonType> affirm = overdraft.showAndWait();
					if(affirm.get() == ButtonType.OK) {
						tempBalance -= temp + 35;
					} else {
						withdraw();
					}
				} else {
					tempBalance += temp;
				}
			} catch (Exception f) {
				errorWindow("Not a number", "Please enter a valid number for your withdrawal.");
				withdraw();
			}
		});
		
	}
	
	public static void deposit() {
		
		TextInputDialog deposit = new TextInputDialog();
		deposit.setTitle("Deposit");
		deposit.setHeaderText("Deposit Money");
		deposit.setContentText("Enter the amount to deposit:");
		
		Optional<String> amount = deposit.showAndWait();
		amount.ifPresent(e -> {
			try {
				double temp = Double.parseDouble(amount.get());
				
				if(temp < 0) {
					errorWindow("Function Mismatch", "Please use the withdraw function for this.");
				} else {
					tempBalance += temp;
				}
			} catch(Exception f) {
				errorWindow("Unknown Error", "Please try again.");
				deposit();
			}
		});
	}
	
	public static void showBalance() {
		DecimalFormat df = new DecimalFormat("#.00");
		
		Alert balanceWindow = new Alert(AlertType.INFORMATION);
		
		balanceWindow.setTitle("Balance");
		balanceWindow.setHeaderText(null);
		if(tempBalance == 0) {
			balanceWindow.setContentText("You have no balance. Use the deposit function to add more.");
		} else {
			balanceWindow.setContentText("You have a balance of $" + df.format(tempBalance));
		}
		
		balanceWindow.showAndWait();
	}
	
	public static void chooseAccount() {
		ObservableList<String> options = FXCollections.observableArrayList();
		for(BankAccount acc : accounts) { //just remember that the indexes are the same. for some reason i cant get the index of the option that was selected.
			options.add(acc.getName());
		}
		
		Button affirm = new Button("Choose");
		
		ComboBox choose = new ComboBox(options);
		
		affirm.setOnAction(e -> {
			editing = choose.getSelectionModel().getSelectedIndex();
		});
		
		GridPane accountGP = new GridPane();
		accountGP.add(affirm, 0, 1);
		accountGP.add(choose, 0, 0);
		
		accountGP.setPadding(new Insets(10));
		accountGP.setVgap(10);
		accountGP.setHgap(10);
		
		GridPane.setHalignment(affirm, HPos.CENTER);
		GridPane.setHalignment(choose, HPos.CENTER);
		
		Scene accountSC = new Scene(accountGP);
		stage.setScene(accountSC);
		
	}
	
	public static void errorWindow(String errorType, String message) { //error window method
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
