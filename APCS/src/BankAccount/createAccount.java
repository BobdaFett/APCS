package BankAccount;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class createAccount {
	
	private static Scene create;
	
	public static void create() {
		TextArea ta = new TextArea();
		
		Button affirm = new Button("_Submit");
		affirm.setOnAction(e -> {
			bankAccountFX.name = ta.getText();
			bankAccountFX.rename.setText("_Rename account " + bankAccountFX.name);
			bankAccountFX.rename.setOnAction(f -> {
				renameFX.rename();
			});
			bankAccountFX.hb.getChildren().clear();
			bankAccountFX.hb.getChildren().addAll(bankAccountFX.rename, bankAccountFX.r2, bankAccountFX.b2);
			bankAccountFX.stage.setScene(bankAccountFX.base);
		});
		
		create = new Scene(new HBox(ta, affirm));
		
		ta.setPromptText("Enter a new name...");
		
		bankAccountFX.stage.setScene(create);
	}
	
	public static void reset() {
		bankAccountFX.stage.setScene(bankAccountFX.base);
	}

}