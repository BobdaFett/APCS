package BankAccount;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class renameFX {
	
	private static Stage ren;
	private static Scene renSC;
	private static TextArea ta;
	private static Text t;
	
	public static void open() {
		ren = new Stage();
		
		t = new Text("Enter a new name for the account: ");
		
		ta = new TextArea();
		ta.setPromptText("Enter a new name...");
		
		Button b1 = new Button("Submit");
		b1.setOnAction(e -> {
			bankAccountFX.name = ta.getText();
			bankAccountFX.hb.getChildren().clear();
			bankAccountFX.hb.getChildren().addAll(bankAccountFX.b1, bankAccountFX.b2);
		});
		
		renSC = new Scene(new HBox(50, b1, ta));
		
		ren.setScene(renSC);
		
		ren.show();
	}
	
	public static void rename() {
		
	}
	
}
