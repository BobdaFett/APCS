package BankAccount;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class createAccount {

	private static Stage create;
	
	public static void open() {
		// TODO Auto-generated method stub
		create = new Stage();
		
		Button b1 = new Button("Create a new account");
		b1.setOnAction(e -> {
			create();
		});
		
		Button b2 = new Button("Back to menu...");
		b2.setOnAction(e -> {
			create.close();
		}); 
		
		Scene base = new Scene(new HBox(b1, b2));
		
		create.setScene(base);
		
		create.show();
	}
	
	private static void create() {
		TextArea ta = new TextArea();
		
		Button affirm = new Button("Submit");
		affirm.setOnAction(e -> {
			bankAccountFX.name.set(ta.getText());
		});
		
		Scene sc = new Scene(new HBox(ta, affirm));
		
		ta.setText("Enter a new name...");
		
		create.setScene(sc);
	}

}
