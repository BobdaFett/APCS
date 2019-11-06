package BankAccount;

import javafx.application.*;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

public class bankAccountFX extends Application {
	
	public static StringProperty name;
	
	public void start(Stage s) throws Exception {
		Button b1 = new Button("Create new bank account");
		b1.setOnAction(e -> {
			createAccount.open();
			b1.setText("Rename account " + name + ".");
		});
		
		name.addListener((obs,oldvariable,newvariable) -> {
			
		});
		
		Button b2 = new Button("Withdraw");
		b2.setOnAction(e -> {
			
		});
		
		Button b3 = new Button("Deposit");
		b3.setOnAction(e -> {
			
		});
		
		Button b4 = new Button("");
		b4.setOnAction(e -> {
			
		});
		
		HBox hb = new HBox(b1, b2);
		
		HBox hb2 = new HBox(b3);
		
		VBox vb = new VBox(hb, hb2);
		
		Scene sc = new Scene(vb);
		s.setScene(sc);
		
		s.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
