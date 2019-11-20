package BankAccount;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class renameFX {
	
	private static Scene rename;
	private static TextArea ta;
	
	public static void rename() {
		ta = new TextArea();
		
		Button affirm = new Button("Submit");
		affirm.setOnAction(e -> {
			bankAccountFX.name = ta.getText();
			bankAccountFX.rename.setText("Rename account " + bankAccountFX.name);
			bankAccountFX.rename.setOnAction(f -> {
				renameFX.rename();
			});
			bankAccountFX.hb.getChildren().clear();
			bankAccountFX.hb.getChildren().addAll(bankAccountFX.rename, bankAccountFX.HBoxRegion, bankAccountFX.b2);
			bankAccountFX.stage.setScene(bankAccountFX.base);
		});
		
		affirm.setDefaultButton(true);
		
		rename = new Scene(new HBox(ta, affirm));
		
		ta.setPromptText("Enter a new name...");
		
		bankAccountFX.stage.setScene(rename);
		
	}
	
}
