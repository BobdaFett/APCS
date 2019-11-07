package BankAccount;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class renameFX {
	
	private static Stage ren;
	private static Scene renSC;
	
	public static void open() {
		ren = new Stage();
		
		Button b1 = new Button("Create a new account");
		b1.setOnAction(e -> {
			
		});
		
		Button b2 = new Button("Back to menu...");
		b2.setOnAction(e -> {
			ren.close();
		}); 
		renSC = new Scene(new HBox(b1, b2));
		
		ren.setScene(renSC);
		
		ren.show();
	}
	
	public static void rename() {
		
	}
	
}
