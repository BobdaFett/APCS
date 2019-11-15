package BankAccount;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class depositFX {
	private static Scene deposit;
	private static Scene error;
	private static Scene textError;
	
	public static void open() {
		TextArea ta = new TextArea();
		ta.setPromptText("Enter your new balance...");
		
		Button affirm = new Button("Submit");
		affirm.setOnAction(e -> {
			
			try {
				if(Double.parseDouble(ta.getText()) > 0) {
					bankAccountFX.balance += Double.parseDouble(ta.getText());
					String temp = String.format("%.2f", bankAccountFX.balance);
					bankAccountFX.currentBalance.setText("Your current balance is $" + temp);
					bankAccountFX.stage.setScene(bankAccountFX.base);
				} else {
					negative();
				}
			} catch(Exception error) {
				error();
			}
		});
		
		deposit = new Scene(new HBox(ta, affirm));
				
		bankAccountFX.stage.setScene(deposit);
		
	}

	public static void negative() {
		Text errorText = new Text("That was a negative number.\nPlease use the withdraw function if you would like to take out money.");
		Button errorButton = new Button("OK");
		errorButton.setOnAction(f -> {
			bankAccountFX.stage.setScene(bankAccountFX.base);
		});
		
		HBox errorHB = new HBox(errorText);
		HBox errorHB2 = new HBox(errorButton);
		
		VBox errorVB = new VBox(errorHB, errorHB2);
		
		error = new Scene(errorVB, 150, 150);
		
		bankAccountFX.stage.setScene(error);
	}
	
	public static void error() {
		Text errorText = new Text("That didn't go through.\nTry again.");
		Button errorButton = new Button("OK");
		errorButton.setOnAction(e -> { open(); });
		
		HBox errorHB = new HBox(errorText);
		HBox errorHB2 = new HBox(errorButton);
		
		VBox errorVB = new VBox(errorHB, errorHB2);
		
		textError = new Scene(errorVB, 150, 150);
		
		bankAccountFX.stage.setScene(textError);
	}
	
}
