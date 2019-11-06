package BankAccount;

import javafx.application.*;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

@SuppressWarnings("exports")
public class bankAccountFX extends Application {
	
	public static StringProperty nameTest;
	public static String name;
	public static Button b1;
	public static Button b2;
	public static Button b3;
	public static Button b4;
	public static Button rename;
	public static HBox hb;
	public static HBox hb2;
	public static VBox vb;
	public static Scene sc;
	
	public void start(Stage s) throws Exception {
		
		b1 = new Button("Create new bank account");
		b1.setOnAction(e -> {
			createAccount.open();
			//b1.setText("Rename account " + name + ".");
		});
		
		rename.setOnAction(e -> {
			renameFX.open();
		});
		
		b2 = new Button("Withdraw");
		b2.setOnAction(e -> {
			
		});
		
		b3 = new Button("Deposit");
		b3.setOnAction(e -> {
			
		});
		
		b4 = new Button("");
		b4.setOnAction(e -> {
			
		});
		
		hb = new HBox(b1, b2);
		
		hb2 = new HBox(b3);
		
		vb = new VBox(hb, hb2);
		
		sc = new Scene(vb);
		s.setScene(sc);
		s.setMaximized(true);
		s.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
